package com.example.demo.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.audio.tts.TextToSpeechPrompt;
import org.springframework.ai.audio.tts.TextToSpeechResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.content.Media;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.api.OpenAiAudioApi.SpeechRequest;
import org.springframework.ai.openai.api.OpenAiAudioApi.SpeechRequest.AudioResponseFormat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/* openai, gemini 관련
 * 
[Gemini 2.5 Flash 적용 가능 여부 및 기능별 처리 방식 정리]

1. STT (stt()) : 가능 ⭕ (단독 처리)
  - Gemini 2.5 Flash는 멀티모달 모델이므로 별도 Whisper 모델 없이 음성 파일(Media)을 
    직접 읽고 텍스트로 받아쓰기가 가능합니다.

2. TTS (tts(), ttsFlux()) : 불가 ❌ (OpenAI 유지)
  - Gemini API는 음성 바이너리(MP3 등) 출력 기능을 제공하지 않습니다. 
    따라서 TTS 전용 모델(openAiAudioSpeechModel)을 계속 사용해야 합니다.

3. 텍스트 대화 (chatText()) : 가능 ⭕ (조합 처리)
  - 텍스트 답변 생성은 Gemini가 담당하고, 해당 텍스트를 음성으로 바꾸는 과정은 
    기존 TTS를 호출하여 조합합니다.

4. 음성 대화 스트리밍 (chatVoiceSttLlmTts()) : 가능 ⭕ (조합 처리)
  - 음성 질문 해석(STT)과 답변 생성을 Gemini가 처리하고, 
    최종 음성 스트리밍만 TTS Flux로 내보냅니다.

5. 원모델 음성 대화 (chatVoiceOneModel()) : 부분 가능 🔺 (2단계 처리)
  - Gemini 모델 자체는 텍스트만 출력할 수 있어서 음성질문->텍스트응답까진 제미나이 가능, 그걸 변환하는 건 tts음성처리 별도 필요.
  - gpt-4o-mini-audio처럼 모델 하나가 바로 음성을 뱉는 건 Gemini 스펙상 불가능합니다.
  - [Gemini(음성 듣고 텍스트 답변 생성) + TTS(음성 변환)]의 2단계 구조로 대체 처리됩니다.
  
	  [4번 : chatVoiceSttLlmTts] - 전통적인 3단계 파이프라인
		 1단계: STT 메서드 호출 (입력 음성 -> 텍스트 질문 변환)
		 2단계: Gemini 호출 (텍스트 질문 -> 텍스트 답변 생성)
		 3단계: TTS Flux 호출 (텍스트 답변 -> 실시간 스트리밍 음성 변환)
		 4번: stt("speech.mp3", audioBytes)를 먼저 실행해서 질문을 '텍스트 글자'로 먼저 바꾼 뒤 Gemini에게 텍스트로 물어봅니다.
	
	  [5번 : chatVoiceOneModel] - Gemini 멀티모달 direct 활용
	 	1단계: Gemini 직접 호출 (입력 음성 Media를 직접 전달 -> Gemini가 듣고 텍스트 답변 생성)
	 	2단계: TTS 호출 (텍스트 답변 -> 단일 음성 바이너리 변환)
 		5번: 별도의 STT 단계 없이, Gemini에게 '음성 파일 그 자체(Media)'를 넘겨주어서 Gemini가 억양이나 뉘앙스를 직접 듣고 답변 텍스트를 작성하게 합니다.
*/
@Service
@Slf4j
public class AiService {

	private ChatClient chatClient;
	// TTS는 Gemini 자체 지원이 안 되므로 OpenAI TTS를 유지하거나, Google TTS 클라이언트를 사용해야 합니다.
	private OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel; // STT 모델
	private OpenAiAudioSpeechModel openAiAudioSpeechModel; // TTS 모델

	// 생성자 주입을 통해 필요한 의존성을 주입받음
	// openai
//	public AiService(ChatClient.Builder chatClientBuilder,
//			@Qualifier("googleGenAiChatModel") ChatModel geminiChatModel,
//			OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel,
//			OpenAiAudioSpeechModel openAiAudioSpeechModel) {
//		chatClient = chatClientBuilder.build();
//		this.openAiAudioTranscriptionModel = openAiAudioTranscriptionModel;
//		this.openAiAudioSpeechModel = openAiAudioSpeechModel;
	
	// gemini버전
	public AiService(
			@Qualifier("googleGenAiChatModel") ChatModel chatModel,
			OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel,
			OpenAiAudioSpeechModel openAiAudioSpeechModel) {
		// Gemini ChatModel 기반으로 ChatClient 생성 : 주입받은 geminiChatModel을 ChatClient.Builder의 기본 모델로 연결!
		this.chatClient = ChatClient.builder(chatModel).build();				
		this.openAiAudioTranscriptionModel = openAiAudioTranscriptionModel;
		this.openAiAudioSpeechModel = openAiAudioSpeechModel;
	}

	// 1. STT (Speech-to-Text) 기능 구현
	public String stt(String fileName, byte[] bytes) {

		// 음성 데이터(byte[])를 ByteArrayResource로 생성하고, getFilename() 메서드를 오버라이드하여 파일 이름을 제공
		Resource audioResource = new ByteArrayResource(bytes) {
			@Override
			public String getFilename() {
				return fileName;
			}
		};

		/* openai버전
		// 모델 옵션 설정
		OpenAiAudioTranscriptionOptions options = OpenAiAudioTranscriptionOptions.builder()
				.model("whisper-1")
				.language("ko")
				.build();

		// 프롬프트 생성
		AudioTranscriptionPrompt prompt = new AudioTranscriptionPrompt(audioResource, options);

		// 모델을 호출하고 응답받기
		AudioTranscriptionResponse response = openAiAudioTranscriptionModel.call(prompt);
		String text = response.getResult().getOutput(); // STT 결과 텍스트 얻기
		*/
		
		// gemini버전
		// MimeType 자동 감지 또는 audio/mp3, audio/wav 등 지정
	    MimeType mimeType = MimeType.valueOf("audio/mp3"); 

	    // Gemini 2.5 Flash가 음성을 듣고 텍스트로 받아적도록 프롬프트 작성
	    String text = chatClient.prompt()
	            .system("당신은 음성을 텍스트로 정확히 받아적는 STT 시스템입니다. 들리는 내용을 있는 그대로 텍스트로만 출력하세요.")
	            .user(userSpec -> userSpec
						.text("첨부된 음성 파일의 내용을 텍스트로 변환해 주세요.")
						.media(new Media(mimeType, audioResource))
				)	            
	            .options(ChatOptions.builder()
	                    .model("gemini-2.5-flash")
	                    .build())
	            .call()
	            .content();
	    
		return text;
	}

	// 2. TTS (Text-to-Speech) 기능 구현 (기본 목소리: ALLOY - 중성적)
	public byte[] tts(String text) {
		return tts(text, SpeechRequest.Voice.ALLOY);
	}

	// 목소리(성별 톤)를 선택할 수 있는 TTS 기능
	// 남성적인 목소리: ECHO, ONYX, ASH, BALLAD, VERSE
	// 여성적인 목소리: NOVA, SHIMMER, CORAL, SAGE
	// 중성적인 목소리: ALLOY, FABLE
	public byte[] tts(String text, SpeechRequest.Voice voice) {
		// 모델 옵션 설정

		OpenAiAudioSpeechOptions options = OpenAiAudioSpeechOptions.builder().model("gpt-4o-mini-tts")
				.voice(SpeechRequest.Voice.ALLOY)
				// TTS 모델 설정
				// 음성 톤 설정
				.responseFormat(SpeechRequest.AudioResponseFormat.MP3).speed(1.0)
				// 출력 음성 형식 설정
				// 음성 속도 설정 (1.0은 기본 속도)
				.build();
		// 프롬프트 생성
		TextToSpeechPrompt prompt = new TextToSpeechPrompt(text, options);

		// 모델을 호출하고 응답받기
		TextToSpeechResponse response = openAiAudioSpeechModel.call(prompt);
		byte[] bytes = response.getResult().getOutput(); // TTS 결과 음성 데이터 얻기
		return bytes;
	}

	// 3. 텍스트도 같이 출력되는 음성 대화
	public Map<String, String> chatText(String question) {
		
		// LLM로 요청하고, 텍스트 응답 얻기
		
		/* openai버전		
		String textAnswer = chatClient.prompt()
				.system("50자 이내로 한국어로 답변해주세요.")
				.user(question)
				.call()
				.content();

		
		// TTS 모델로 요청하고 응답으로 받은 음성 데이터를 base64 문자열로 변환
		byte[] audio = tts(textAnswer);
		String base64Audio = Base64.getEncoder().encodeToString(audio);

		// 텍스트 답변과 음성 답변을 Map에 저장
		Map<String, String> response = new HashMap<>();
		response.put("text", textAnswer);
		response.put("audio", base64Audio);
		*/
		
		// gemini버전
		// Gemini로 텍스트 답변 생성
	    String textAnswer = chatClient.prompt()
	            .system("50자 이내로 한국어로 답변해주세요.")
	            .user(question)
	            .options(ChatOptions.builder()
	                    .model("gemini-2.5-flash")
	                    .temperature(0.3)
	                    .build())
	            .call()
	            .content();

	    // 답변 텍스트를 TTS로 변환 (OpenAI TTS 또는 별도 TTS 활용)
	    byte[] audio = tts(textAnswer);
	    String base64Audio = Base64.getEncoder().encodeToString(audio);

	    Map<String, String> response = new HashMap<>();
	    response.put("text", textAnswer);
	    response.put("audio", base64Audio);

		return response;
	}

	// 비동기 TTS 기능 구현
	public Flux<byte[]> ttsFlux(String text) {
		// 모델 옵션 설정
		OpenAiAudioSpeechOptions options = OpenAiAudioSpeechOptions.builder().model("gpt-4o-mini-tts")
				.voice(SpeechRequest.Voice.ALLOY).responseFormat(AudioResponseFormat.MP3).speed(1.0).build();

		// 프롬프트 생성
		TextToSpeechPrompt prompt = new TextToSpeechPrompt(text, options);

		// 모델로 요청하고 응답받기
		Flux<TextToSpeechResponse> response = openAiAudioSpeechModel.stream(prompt);
		Flux<byte[]> flux = response.map(speechResponse -> speechResponse.getResult().getOutput());
		return flux;
	}

	// 4. 순수 음성 대화 구현 (방법1)
	public Flux<byte[]> chatVoiceSttLlmTts(byte[] audioBytes) {
		// STT를 이용해서 음성 질문을 텍스트 질문으로 변환
		String textQuestion = stt("speech.mp3", audioBytes);

		// 텍스트 질문으로 LLM에 요청하고, 텍스트 응답 얻기
		String textAnswer = chatClient.prompt().system("50자 이내로 답변해주세요.").user(textQuestion).call().content();

		// TTS를 이용해서 비동기 음성 데이터 얻기
		Flux<byte[]> flux = ttsFlux(textAnswer);
		return flux;
	}

	// 5. 순수 음성 대화 구현 (방법2)
	public byte[] chatVoiceOneModel(byte[] audioBytes, String mimeType) throws Exception {
	/* openai버전
		// 음성 데이터를 Resource로 생성
		Resource resource = new ByteArrayResource(audioBytes);

		// 사용자 메시지 생성
		UserMessage userMessage = UserMessage.builder()
				// 빈문자열이라도 제공해야함
				.text("제공되는 음성에 맞는 자연스러운 대화로 이어주세요.").media(new Media(MimeType.valueOf(mimeType), resource)).build();

		// 모델 옵션 설정
		ChatOptions chatOptions = OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.GPT_4_O_MINI_AUDIO_PREVIEW) // gpt-4o-mini-audio
																													// 모델
																													// 사용
				.outputModalities(List.of("text", "audio"))
				.outputAudio(new AudioParameters(ChatCompletionRequest.AudioParameters.Voice.ALLOY,
						ChatCompletionRequest.AudioParameters.AudioResponseFormat.MP3))
				.build();

		// gpt-4o-mini-audio 모델은 스트림을 지원하지 않기 때문에 동기 방식 사용
		// 모델로 요청하고 응답 받기
		ChatResponse response = chatClient.prompt().system("50자 이내로 답변해주세요.").messages(userMessage).options(chatOptions)
				.call().chatResponse();

		// AI 메시지 얻기
		AssistantMessage assistantMessage = response.getResult().getOutput();

		// 텍스트 답변 얻기
		String textAnswer = assistantMessage.getText();
		log.info("텍스트 응답: {}", textAnswer);

		// 오디오 답변 얻기
		byte[] audioAnswer = assistantMessage.getMedia().get(0).getDataAsByteArray();

		return audioAnswer;
		*/
		
		// gemini버전
		Resource resource = new ByteArrayResource(audioBytes);

	    // Gemini가 질문 음성을 직접 듣고 텍스트로 답변 생성
	    String textAnswer = chatClient.prompt()
	            .system("사용자의 질문 음성을 듣고, 50자 이내의 친절한 한국어로 답변해 주세요.")
	            .user(userSpec -> userSpec
	                    .text("제공되는 음성에 맞는 자연스러운 대화로 이어주세요.")
	                    .media(new Media(MimeType.valueOf(mimeType), resource))
	            )
	            .options(ChatOptions.builder()
	                    .model("gemini-2.5-flash")
	                    .build())
	            .call()
	            .content();

	    log.info("Gemini 텍스트 응답: {}", textAnswer);

	    // 생성된 텍스트 답변을 TTS를 통해 바이너리 음성(MP3)으로 변환하여 반환
	    return tts(textAnswer);
		
	}

}
