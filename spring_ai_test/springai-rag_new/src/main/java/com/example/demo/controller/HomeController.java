package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/txt-pdf-word-etl")
  public String txtPdfDocxEtl() {
    return "txt-pdf-word-etl";
  }

  @GetMapping("/html-etl")
  public String htmlEtl() {
    return "html-etl";
  }

  @GetMapping("/json-etl")
  public String jsonEtl() {
    return "json-etl";
  }

  @GetMapping("/rag")
  public String rag() {
    return "rag";
  }
  
}
