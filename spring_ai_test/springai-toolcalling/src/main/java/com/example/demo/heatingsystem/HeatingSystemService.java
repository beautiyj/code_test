package com.example.demo.heatingsystem;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HeatingSystemService {
  
  private ChatClient chatClient;

  @Autowired
  private HeatingSystemTools heatingSystemTools; 	

  // 생성자
  public HeatingSystemService(ChatModel chatModel) {
    this.chatClient = ChatClient.builder(chatModel).build();
  }

  // 난방 시스템을 제어하는 서비스 메서드
  public String chat(String question) {
    String answer = chatClient.prompt()	    
        .system("""						  
          현재 온도가 사용자가 원하는 온도 이상이라면 난방 시스템을 중지하세요.
          현재 온도가 사용자가 원하는 온도 이하라면 난방 시스템을 가동시켜주세요.
        """)
        .user(question)					// 사용자의 질문을 전달
        .tools(heatingSystemTools)		// 난방 시스템 제어 도구를 등록
        .toolContext(Map.of("controlKey", "heatingSystemKey")) // 난방 시스템 제어 권한을 부여
        .call()							// 난방 시스템 제어 도구를 호출하도록 LLM에게 요청		
        .content();					    // 난방 시스템 제어 도구의 결과를 반환
    return answer;
  }
}
