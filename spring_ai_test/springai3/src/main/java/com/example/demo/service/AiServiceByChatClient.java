package spring_ai_test.springai3.src.main.java.com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class AiServiceByChatClient {

	private ChatClient chatClient;

	public AiServiceByChatClient(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}

	// 질문에 대한 답변을 문자로 생성하는 메서드
	public String generateText(String question) {
		String answer = chatClient.prompt().system("사용자 질문에 대해 한국어로 답변을 해야 합니다.").user(question)
				.options(ChatOptions.builder()
//						.model("gpt-4o")		   // OPEN AI의 경우 사용하는 만큼 과금 형태, 무료X
						.model("gemini-2.5-flash") // GEMINI AI의 경우 이걸로. 260630기준 2.5부터 지원함
						.temperature(0.3).maxTokens(1000) // 최대 토큰 수, 유동적으로 조절
						.build())
				.call() // 문자 형태로 요청
				.content();
		return answer;
	}

	// 질문에 대한 답변을 스트리밍으로 생성하는 메서드
	public Flux<String> generateStreamText(String question) {
		Flux<String> fluxString = chatClient.prompt().system("사용자 질문에 대해 한국어로 답변을 해야합니다.").user(question)
				.options(ChatOptions.builder()
//						.model("gpt-4o")
						.model("gemini-2.5-flash")
						.temperature(0.3)
						.maxTokens(5000)
						.build())
				.stream() // 스트리밍 방식으로 요청
				.content();
		return fluxString;
	}

}
