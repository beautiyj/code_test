package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class AiServiceRoleAssignmentPrompt {
	private ChatClient chatClient;

	// 생성자
	public AiServiceRoleAssignmentPrompt(ChatClient.Builder chatClientBuilder) {
		chatClient = chatClientBuilder.build();
	}

	public Flux<String> roleAssignment(String requirements) {
		Flux<String> travelSuggestions = chatClient.prompt()
				// 시스템 메시지 추가
				.system("""
						당신이 여행 가이드 역할을 해주었으면 좋겠습니다.
						아래 요청사항에서 위치를 알려주면, 근처에 있는 3곳을 제안해주고,
						이유를 달아주세요. 경우에 따라서 방문하고 싶은 장소 유형을 제공할수도 있습니다.
						""")
				// 사용자 메시지 추가
				.user("요청사항: %s".formatted(requirements))
				// 대화 옵션 설정
				.options(ChatOptions.builder().model("gemini-2.5-flash").temperature(1.0) // 모델의 출력 다양성설정(1.0은 높은 다양성)
//						.maxTokens(1000)
						.build())
				// LLM으로 요청하고 응답얻기
				.stream() // 모델 호출
				.content(); // 모델의 응답에서 콘텐츠 추출
		return travelSuggestions;
	}

}
