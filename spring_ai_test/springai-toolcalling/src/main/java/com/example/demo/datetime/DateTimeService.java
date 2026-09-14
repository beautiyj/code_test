package com.example.demo.datetime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DateTimeService {
  
  private ChatClient chatClient;

  @Autowired
  private DateTimeTools dateTimeTools;   // DateTimeTools를 주입

  // 생성자
  public DateTimeService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder
        .build();
  }

  // 질문을 받아서 LLM에게 전달하고, LLM이 DateTimeTools를 호출하도록 함
  public String chat(String question) {
    String answer = this.chatClient.prompt()  
        .user(question)
        .tools(dateTimeTools)  		// DateTimeTools를 LLM에게 전달
        .call()						// DateTimeTools를 호출하도록 LLM에게 요청
        .content();             	// 도구 호출 결과를 반환
    return answer;
  }
}
