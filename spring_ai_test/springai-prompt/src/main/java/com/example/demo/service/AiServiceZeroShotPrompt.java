package com.example.demo.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiServiceZeroShotPrompt {

	private ChatClient chatClient;

	// 영화 리뷰를 분류하기 위한 프롬프트 템플릿 정의
	private PromptTemplate promptTemplate = PromptTemplate.builder()
		.template("""
			영화리뷰를[긍정적, 중립적, 부정적] 중에서 하나로 분류하세요.
			레이블만 반환하세요.
			리뷰: {review}
			""")
		.build();

	// 생성자
	public AiServiceZeroShotPrompt(ChatClient.Builder chatClientBuilder) {
		chatClient = chatClientBuilder.defaultOptions(ChatOptions.builder()
//				.model("gpt-4o-mini") // 사용할 모델 설정
				.model("gemini-2.5-flash") // 사용할 모델 설정
				.temperature(0.0)	// 모델의 출력 다양성 설정 (0.0은 결정적 출력)
//				.maxTokens(20)	// 최대 토큰 수 - 감정레이블만 필요하므로 토큰 4~ 제한
				.build())
			.build();
	}

	// 영화 리뷰를 입력받아 감정을 분류하는 메서드
	public String zeroShotPrompt(String review) {
		log.info("받은 리뷰 데이터: {}", review);
		String sentiment = chatClient.prompt()	// 프롬프트를 사용하여 감정 분석 수행
				.user(promptTemplate.render(Map.of("review", review))) // 프롬프트에 리뷰를 전달
				.call()			// 모델 호출
				.content();		// 모델의 응답에서 감정 레이블 추출
		log.info("AI가 반환한 최종 content(): [{}]", sentiment);
		return sentiment;
	}

}
