package com.example.demo.controller;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AiService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiController {

  @Autowired
  private AiService aiService;
  
  // 1. text-embedding 요청
  @PostMapping(
      value = "/text-embedding",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String textEmbedding(@RequestParam("question") String question) {
    aiService.textEmbedding(question);
    return "서버 터미널(콘솔) 출력을 확인하세요.";
  }
  
  // 2. add-document 요청
  @PostMapping(
      value = "/add-document",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String addDocument(@RequestParam("question") String question) {
    aiService.addDocument();
    return "벡터 저장소에 Document들이 저장되었습니다.";
  }  
  
  // 3. search-document-1 요청
  @PostMapping(
      value = "/search-document-1",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String searchDocument1(@RequestParam("question") String question) {
    List<Document> documents = aiService.searchDocument1(question);    
    if (documents == null || documents.isEmpty()) {
      return "검색 결과가 없습니다.";
    }
    
    StringBuilder text = new StringBuilder();
    for (Document document : documents) {
      Object year = document.getMetadata() == null ? null : document.getMetadata().get("year");
      double score = document.getScore() == null ? 0.0 : document.getScore();

      text.append("<div class='mb-2'>");
      text.append("  <span class='me-2'>유사도 점수: %.4f,</span>".formatted(score));
      text.append("  <span>%s(%s)</span>".formatted(document.getText(), year == null ? "연도 없음" : year));
      text.append("</div>");
    }
    return text.toString();
  }  
  
  // 4. search-document-2 요청
  @PostMapping(
      value = "/search-document-2",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String searchDocument2(@RequestParam("question") String question) {
    if (question == null || question.isBlank()) {
      return "질문을 입력해주세요.";
    }

    List<Document> documents = aiService.searchDocument2(question);

    if (documents == null || documents.isEmpty()) {
      return "조건에 맞는 검색 결과가 없습니다.";
    }

    StringBuilder text = new StringBuilder();
    for (Document document : documents) {
      Object year = document.getMetadata() == null ? null : document.getMetadata().get("year");
      double score = document.getScore() == null ? 0.0 : document.getScore();

      text.append("<div class='mb-2'>");
      text.append("  <span class='me-2'>유사도 점수: %.4f,</span>".formatted(score));
      text.append("  <span>%s(%s)</span>".formatted(document.getText(), year == null ? "연도 없음" : year));
      text.append("</div>");
    }

    return text.toString();
  }  
  
  // 5. delete-document 요청
  @PostMapping(
      value = "/delete-document",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String deleteDocument(@RequestParam(value = "question", required = false) String question) {
    aiService.deleteDocument();
    return "Document들이 삭제되었습니다.";
  } 
}