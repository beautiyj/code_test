package com.example.demo.recommendmovie;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecommendMovieService {
  
  private ChatClient chatClient;

  @Autowired
  private RecommendMovieTools recommendMovieTools;   // RecommendMovieTools 주입

  // 생성자
  public RecommendMovieService(ChatModel chatModel) {
    this.chatClient = ChatClient.builder(chatModel).build();
  }

  // 사용자 질문을 받아 LLM에게 전달하고, LLM의 응답을 반환
  public String chat(String question) {
    String answer = chatClient.prompt()  // 프롬프트 시작
        .user(question)					 // 사용자 질문
        .tools(recommendMovieTools)      // RecommendMovieTools 도구 등록
        .call()							 // LLM 호출
        .content();						 // LLM 응답 내용
    return answer;
  }
}
