package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
  @GetMapping("/")
  public String home() {
    return "home";
  }
  
  //1. 텍스트 임베딩
  @GetMapping("/text-embedding")
  public String textEmbedding() {
    return "text-embedding";
  }  
  
  //2. 문서 추가
  @GetMapping("/add-document")
  public String addDocument() {
    return "add-document";
  }   
  
  //3. 문서 검색1
  @GetMapping("/search-document-1")
  public String searchDocument1() {
    return "search-document-1";
  }   
  
  //4. 문서 검색2
  @GetMapping("/search-document-2")
  public String searchDocument2() {
    return "search-document-2";
  }  
  
  //5. 문서 삭제
  @GetMapping("/delete-document")
  public String deleteDocument() {
    return "delete-document";
  } 
  
  //6. 이미지 임베딩
  @GetMapping("/image-embedding")
  public String faceRecognition() {
    return "image-embedding";
  }  
  
}
