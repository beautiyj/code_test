package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiServiceFewShotPrompt {

	private ChatClient chatClient;

	// 생성자
	public AiServiceFewShotPrompt(ChatClient.Builder chatClientBuilder) {
		chatClient = chatClientBuilder.build();
	}

	// 고객 주문을 입력받아 JSON 형식으로 변환하는 메서드
	public String fewShotPrompt(String order) {
		// 프롬프트 생성 - 마크다운 내용은 제미나이 한정
		String strPrompt = """
				고객 주문을 유효한 JSON 형식으로 바꿔주세요.
				마크다운 기호(```json 등)를 절대 포함하지 말고, 순수 JSON 문자열만 반환하세요.
				추가 설명은 포함하지 마세요.
				예시 1:
				작은 피자 하나, 치즈랑 토마토 소스, 페퍼로니 올려서 주세요.
				JSON 응답:
				{
				"size": "small",
				"type": "normal",
				"ingredients": ["cheese", "tomato sauce", "pepperoni"]
				}
				예시 2:
				큰 피자 하나, 토마토 소스랑 바질, 모짜렐라 올려서 주세요.
				JSON 응답:
				{
				"size": "large",
				"type": "normal",
				"ingredients": ["tomato sauce", "basil", "mozzarella"]
				}
				예시 3:
				큰 피자로 반반 해서, 한쪽은 불고기랑 치즈, 다른 한쪽은 포테이토랑 베이컨 올려주세요.
				JSON 응답:
				{
				"size": "large",
				"type": "half-and-half",
				"half1": {
					"ingredients": ["bulgogi", "cheese"]
				},
				"half2": {
					"ingredients": ["potato", "bacon"]
				}
				}
				고객주문: %s""".formatted(order);

		Prompt prompt = Prompt.builder() // 프롬프트 빌드 생성
				.content(strPrompt) // 프롬프트 내용 생성
				.build();
		// LLM으로 요청하고 응답을받음
		String pizzaOrderJson = chatClient.prompt(prompt).options(ChatOptions.builder() // 대화 옵션 설정
//				.model("gpt-4o-mini")
				.model("gemini-2.5-flash")
				.temperature(0.0)
//				.maxTokens(300)
				.build()).call().content();
		return pizzaOrderJson;
	}
}
