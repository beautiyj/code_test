package com.example.demo.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.image.ImageMessage;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MimeType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.service.AiService.OpenAIImageEditResponse;
import com.example.demo.service.AiService.OpenAIImageEditResponse.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// 	                    .model("gemini-2.5-flash")

/*
====================================================================================================
 [제시해주신 서비스 코드의 Gemini 전환 및 적용 가능 여부 분석]
====================================================================================================

1. 이미지 분석 (imageAnalysis()) : 가능 ⭕ (Gemini 2.5 Flash로 전환 가능)
   - 앞서 구성하신 STT 방식과 동일합니다.
   - 사용자 메시지(userMessage)에 .text(question)와 .media(media)가 이미 모두 포함되어 있어서 
     Google GenAI 규격(.text() 필수 조건)에 완벽하게 부합합니다.
   - 생성자에서 Gemini용 ChatModel을 받아주셨다면 별도 수정 없이 Gemini가 이미지를 정상 분석합니다.

2. 이미지 생성 (generateImage()) : 모델만 변경 불가능 ❌ (OpenAI 전용 유지 권장)
   - OpenAI의 DALL-E 3 (또는 ImageModel) 전용 구조로 설계되어 있습니다.
   - Gemini(LLM)는 이미지를 생성해 바이너리로 내보내는 기능이 없으므로, 이미지 생성은 기존의 
     OpenAiImageModel(dall-e-3)을 유지하는 것이 가장 좋습니다.

3. 이미지 편집 (editImage()) : 모델만 변경 불가능 ❌ (OpenAI WebClient 호출 유지)
   - OpenAI REST API (https://api.openai.com/v1/images/edits)를 WebClient로 직접 호출하는 방식입니다.
   - 이는 OpenAI API 전용 규격(OpenAI API Key 및 전용 엔드포인트)이므로 Gemini로 대체할 수 없으며, 
     기존 OpenAI API 방식을 그대로 사용하셔야 합니다.
     
     
     #Google AI Studio 무료 API 키 (gemini-api-key):
	#우리가 흔히 AI Studio에서 발급받는 무료/개인용 키입니다.
	#이 키는 텍스트/이미지 분석(Gemini 2.5 Flash 등)에는 사용할 수 있지만, Imagen 3 이미지 생성 모델은 지원하지 않거나 제한됩니다.
	
	#Vertex AI (GCP Google Cloud Platform):
	#project-id와 location은 Google Cloud 콘솔에서 프로젝트를 생성했을 때 나오는 프로젝트 식별자입니다.
	#Imagen 3를 통한 이미지 생성/편집은 Google Cloud Vertex AI 인프라를 사용하므로
	#GCP 결제 계정(신규 가입 시 제공되는 $300 무료 크레딧 활용 가능) 연동이 필요합니다.
	# Spring AI - Google Vertex AI 설정 (application.properties)
	#spring.ai.vertex.ai.gemini.project-id=your-gcp-project-id
	#spring.ai.vertex.ai.gemini.location=us-central1
	#spring.ai.vertex.ai.gemini.api-key=your-google-api-key


====================================================================================================

 * */
@Service
@Slf4j
public class AiService {
	private ChatClient chatClient;

	// 🚨 [원인 해결] OpenAI API 키 미설정으로 인한 ImageModel 빈 생성 에러 방지를 위해 임시 주석 처리
	// @Autowired
	// private ImageModel imageModel; // VertexAiImagenImageModel 또는 OpenAiImageModel 연동 시 사용

	// application.properties의 spring.ai.openai.api-key 값을 주입받음
	// (System.getenv("OPENAI_API_KEY")는 환경변수가 설정되어 있지 않으면 null이 되어 401 에러 발생)
	@Value("${spring.ai.openai.api-key:dummy-key-for-test}") // 키 미설정 시 기본값 부여하여 주입 에러 방지
	private String openAiApiKey;

	// 💡 Google GenAI(Gemini) 전용 ChatModel을 명시적으로 빈 주입받아 ChatClient 생성
	public AiService(@Qualifier("googleGenAiChatModel") ChatModel chatModel) {
		this.chatClient = ChatClient.builder(chatModel).build();
	}

	// 1. 이미지 분석 메소드 (Gemini 사용 가능)
	public Flux<String> imageAnalysis(String question, String contentType, byte[] bytes) {
		// 시스템 메시지 생성
		SystemMessage systemMessage = SystemMessage.builder().text("""
				당신은 이미지 분석 전문가입니다.
				사용자 질문에 맞게 이미지를 분석하고 답변을 한국어로 하세요.
				""").build();

		// 미디어 생성
		Media media = Media.builder().mimeType(MimeType.valueOf(contentType)) // 이미지의 MIME 타입 설정
				.data(new ByteArrayResource(bytes)) // 이미지 데이터를 ByteArrayResource로 감싸서 설정
				.build();

		// 사용자 메시지 생성
		UserMessage userMessage = UserMessage.builder().text(question).media(media).build();

		// 프롬프트 생성
		Prompt prompt = Prompt.builder().messages(systemMessage, userMessage).build();

		// LLM에 요청하고, 응답받기
		Flux<String> flux = chatClient.prompt(prompt).stream() // 스트리밍 응답
				.content(); // 스트리밍 응답의 텍스트만 추출
		return flux;

	}

//---------------------------------------------------------------------------------------

	// 한글 문장을 영어 문장으로 번역하는 메소드
	private String koToEn(String text) {
		String question = """
				  당신은 번역사입니다. 아래 한글 문장을 영어 문장으로 번역해주세요.
				  %s
				""".formatted(text);

		// UserMessage 생성
		UserMessage userMessage = UserMessage.builder().text(question).build();

		// Prompt 생성
		Prompt prompt = Prompt.builder().messages(userMessage).build();

		// LLM을 호출하고 텍스트 답변 얻기
		String englishDescription = chatClient.prompt(prompt).call().content();
		return englishDescription;
	}

//2. 이미지를 새로 생성하는 메소드 (ImageModel 의존성 이슈로 전체 주석 처리)
/*
	public String generateImage(String description) {

	// 한글 질문을 영어 질문으로 번역
	String englishDescription = koToEn(description);
	// 이미지 설명을 포함하는ImageMessage 생성
	ImageMessage imageMessage = new ImageMessage(englishDescription);

	// gpt-image-1 옵션 설정
	OpenAiImageOptions imageOptions = OpenAiImageOptions.builder().model("gpt-image-1") // gpt-image-1 모델 사용
			.quality("low") // 이미지 품질 설정(low, medium, high)
			.width(1536) // 이미지 가로 크기설정
			.height(1024) // 이미지 세로 크기설정
			.N(1) // 생성할 이미지 수설정
			.build();

	// dall-e 시리즈 옵션 설정
	// OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
	// // dall-e 시리즈 옵션
	// .model("dall-e-3")
	// .responseFormat("b64_json")
	// .width(1024)
	// .height(1024)
	// .N(1)
	// .build();

	// 프롬프트 생성
	List<ImageMessage> imageMessageList = List.of(imageMessage);
	ImagePrompt imagePrompt = new ImagePrompt(imageMessageList, imageOptions);
	// 모델 호출 및 응답받기
	ImageResponse imageResponse = imageModel.call(imagePrompt);
	// base64로 인코딩된 이미지 문자열 얻기
	String b64Json = imageResponse.getResult().getOutput().getB64Json();
	return b64Json;

	}
*/

//
//	public String generateImage(String description) {
//		// 1. 한글 질문을 영어로 번역
//		String englishDescription = koToEn(description);
//
//		// 2. Imagen 3 옵션 설정 (Google Vertex AI 규격)
//		// Spring AI의 VertexAiImagenImageOptions 활용
////	    ImageMessage imageMessage = new ImageMessage(englishDescription);
////	    
////	    // 3. ImagePrompt 생성 및 이미지 생성 요청
////	    ImagePrompt imagePrompt = new ImagePrompt(imageMessage);
//		// 2. ImagePrompt 생성 (ImageMessage가 아닌 String 텍스트를 직접 넘겨줍니다)
//		ImagePrompt imagePrompt = new ImagePrompt(englishDescription);
//		ImageResponse response = imageModel.call(imagePrompt);
//
//		// 4. 생성된 이미지 결과 반환 (Base64 또는 URL)
//		String b64Json = response.getResult().getOutput().getB64Json();
//		return b64Json;
//	}

	// ---------------------------------------------------------------------------------------

	// 3. 원본 이미지를 편집하는 메소드 (OpenAI 전용이므로 주석 처리)
//	public String editImage(String description, byte[] originalImage, byte[] maskImage) {
//		// 한글 질문을 영어 질문으로 번역
//		String englishDescription = koToEn(description);
//
//		// 원본 이미지를 ByteArrayResource로 생성
//		ByteArrayResource originalRes = new ByteArrayResource(originalImage) {
//			@Override
//			public String getFilename() {
//				return "image.png"; // 가상 파일 이름 반환(확장명으로 타입 정보 획득)
//			}
//		};
//
//		// 마스크 이미지를 ByteArrayResource로 생성
//		ByteArrayResource maskRes = new ByteArrayResource(maskImage) {
//			@Override
//			public String getFilename() {
//				return "mask.png"; // 가상 파일 이름 반환
//			}
//		};
//
//		// 이미지 모델 옵션 설정
//		MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
//		form.add("model", "gpt-image-1");
//		form.add("image", originalRes);
//		form.add("mask", maskRes);
//		form.add("prompt", englishDescription);
//		form.add("n", "1");
//		form.add("size", "1536x1024");
//		form.add("quality", "high");
//
//		// WebClient 생성
//		WebClient webClient = WebClient.builder()
//				// 이미지 편집을 위한 요청 URL
//				.baseUrl("https://api.openai.com/v1/images/edits")
//				// 인증 헤더 설정
////     .defaultHeader("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY"))
//				.defaultHeader("Authorization", "Bearer " + openAiApiKey)
//				// 전략을 적용해서 메모리를 늘림
//				.exchangeStrategies(ExchangeStrategies.builder()
//						.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(10 * 1536 * 1024)).build())
//				.build();
//
//		// 비동기 단일값(OpenAIImageEditResponse) 스트림인 Mono 얻기
//		Mono<OpenAIImageEditResponse> mono = webClient.post()
//				// multipart/form-data 형식으로 전송
//				.contentType(MediaType.MULTIPART_FORM_DATA)
//				// 요청 본문에 form 데이터를 넣음
//				.body(BodyInserters.fromMultipartData(form))
//				// 응답 받기
//				.retrieve()
//				// 응답 본문의 JSON을 OpenAIImageEditResponse 타입으로 역직렬화해서
//				// 비동기 단일값(OpenAIImageEditResponse) 스트림인 Mono로 반환
//				.bodyToMono(OpenAIImageEditResponse.class);
//
//		// Mono가 완료될 때까지 현재 스레드를 블로킹하고,
//		// 동기 방식으로 단일값 OpenAIImageEditResponse를 얻음
//		OpenAIImageEditResponse response = mono.block();
//
//		// 레코드로부터 base64로 인코딩된 이미지 문자열 얻기
//		String b64Json = response.data().get(0).b64_json();
//		return b64Json;
//
//		// 클래스로부터 base64로 인코딩된 이미지 문자열 얻기
//		// String b64Json = response.getData().get(0).getB64_json();
//		// return b64Json;
//	}

	@Value("${spring.ai.vertex.ai.gemini.project-id:my-project-id}")
	private String projectId;

	@Value("${spring.ai.vertex.ai.gemini.location:us-central1}")
	private String location;

	@Value("${google.access-token:my-access-token}")
	private String googleAccessToken;

/*
	public String editImage(String description, byte[] originalImage, byte[] maskImage) {
		// 1. 번역
		String englishDescription = koToEn(description);

		// 2. 이미지를 Base64 인코딩
		String base64Original = Base64.getEncoder().encodeToString(originalImage);
		String base64Mask = Base64.getEncoder().encodeToString(maskImage);

		// 3. Google Imagen 3 Edit REST API Request Body 구성
		Map<String, Object> requestBody = Map.of("instances",
				List.of(Map.of("prompt", englishDescription, "image", Map.of("bytesBase64Encoded", base64Original),
						"mask", Map.of("image", Map.of("bytesBase64Encoded", base64Mask)))),
				"parameters", Map.of("sampleCount", 1, "mode", "outpainting" // 또는 "inpainting-insert"
				));

		// 4. Google Vertex AI Imagen Edit 엔드포인트 WebClient 생성
		WebClient webClient = WebClient.builder().baseUrl(String.format(
				"https://%s-aiplatform.googleapis.com/v1/projects/%s/locations/%s/publishers/google/models/imagen-3.0-generate-001:predict",
				location, projectId, location)).defaultHeader("Authorization", "Bearer " + googleAccessToken).build();

		// 5. API 호출 및 응답 디코딩
		Mono<Map> responseMono = webClient.post().contentType(MediaType.APPLICATION_JSON).bodyValue(requestBody)
				.retrieve().bodyToMono(Map.class);

		Map response = responseMono.block();

		// 6. 결과 Base64 문자열 추출
		List<Map<String, Object>> predictions = (List<Map<String, Object>>) response.get("predictions");
		String editedImageBase64 = (String) predictions.get(0).get("bytesBase64Encoded");

		return editedImageBase64;
	}
*/

	// 레코드로 역직렬화할 경우
	// {"data": [{"url": "xxxxx", "b64_json": "xxxxx"}, ... ]}
	// 선언된 필드 외에 JSON에 포함된 속성들을 무시
	@JsonIgnoreProperties(ignoreUnknown = true)
	public record OpenAIImageEditResponse(List<Image> data) {
		@JsonIgnoreProperties(ignoreUnknown = true)
		public record Image(String url, String b64_json) {
		}
	}

	// 클래스로 역직렬화할 경우
	// {"data": [{"url": "xxxxx", "b64_json": "xxxxx"}, ... ]}
	// @Data
	// @JsonIgnoreProperties(ignoreUnknown = true)
	// public static class OpenAIImageEditResponse {
	// private List<Image> data;
	// @Data
	// @JsonIgnoreProperties(ignoreUnknown = true)
	// public static class Image {
	// private String url;
	// private String b64_json;
	// }
	// }

}