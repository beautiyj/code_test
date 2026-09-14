package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AiService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/ai")
@Slf4j
public class AiController {
 
  @Autowired
  private AiService aiService;
  
  // vectorStore에 질문을 저장하고, 유사한 질문을 검색하여 답변을 생성하는 메소드
  @PostMapping(
    value = "/chat",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String vectorStoreChatMemory(    
	@RequestParam("question") String question, HttpSession session) {
	  
	  // 세션에 질문을 저장, 세션이 유지되는 동안 동일한 대화 ID를 사용하여 LLM과의 대화를 이어갈 수 있음
	  session.setAttribute("question", 1); 
	  String answer = aiService.chat(question, session.getId());
	  
    return answer;
  }    
  
}
