package com.example.demo.internetsearch;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InternetSearchService {
  
  private ChatClient chatClient;

  @Autowired
  private InternetSearchTools internetSearchTools;

  // 생성자 
  public InternetSearchService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  // 사용자 질문을 받아서 LLM에게 전달하고, 도구를 사용하여 답변을 생성
  public String chat(String question) {
    String answer = this.chatClient.prompt()   // 프롬프트 시작
        .user(question)                        // 사용자 질문 추가
        .tools(internetSearchTools)            // 도구 추가
        .call()                                // LLM 호출
        .content();							   // 응답 내용 추출
    return answer;
  }
}
