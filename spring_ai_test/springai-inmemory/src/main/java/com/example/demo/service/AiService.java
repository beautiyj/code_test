package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiService {

	private ChatClient chatClient;

	// 생성자
	public AiService(ChatMemory chatMemory, // ChatMemory를 주입받음
			ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(), // ChatMemory를
																													// 이용한
																													// MessageChatMemoryAdvisor를
																													// 추가
				// PromptChatMemoryAdvisor.builder(chatMemory).build(), //
				// PromptChatMemoryAdvisor를 추가
				new SimpleLoggerAdvisor(Ordered.LOWEST_PRECEDENCE - 1) // SimpleLoggerAdvisor를 추가 (로그 출력용)
		).build();
	}

	// chat 메서드
	public String chat(String userText, String conversationId) {
		String answer = chatClient.prompt() // prompt() 메서드를 호출하여 프롬프트를 생성
				.user(userText) // user() 메서드를 호출하여 사용자 입력을 설정
				.advisors(advisorSpec -> advisorSpec.param( // advisors() 메서드를 호출하여 advisorSpec을 설정
						ChatMemory.CONVERSATION_ID, conversationId // conversationId를 설정
				)).call() // call() 메서드를 호출하여 프롬프트를 실행
				.content(); // content() 메서드를 호출하여 결과를 가져옴
		return answer;
	}

}
