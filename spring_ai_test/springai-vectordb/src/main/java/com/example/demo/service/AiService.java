package com.example.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiService {
  
  private ChatClient chatClient;

  // 생성자
  public AiService(
      VectorStore vectorStore,  // application.properties 설정을 반영(chat_vectore_store)
      ChatClient.Builder chatClientBuilder) {    

    // ChatClient를 사용하여 챗봇 기능 구현
    this.chatClient = chatClientBuilder
        .defaultAdvisors(
            VectorStoreChatMemoryAdvisor.builder(vectorStore)
            //.defaultTopK(5) 	//유사도 검색 후에 가져오는 메시지 수, 기본 20개
            .build(),
            new SimpleLoggerAdvisor(Ordered.LOWEST_PRECEDENCE - 1)  
          )  // 로그를 기록하는 어드바이저, 우선순위를 낮게 설정하여 다른 어드바이저보다 먼저 실행되도록 함
        .build();
  }

  
  
  // LLM에게 사용자 입력을 전달하고, 유사한 질문을 검색하여 답변을 생성 
  public String chat(String userText, String conversationId) {
    


    return "";
  }
  
}
