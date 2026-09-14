package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
  @GetMapping("/")
  public String home() {
    return "home";
  }
  
  @GetMapping("/zero-shot-prompt")
  public String zeroShotPrompt() {
    return "zero-shot-prompt";
  }  
  
  @GetMapping("/few-shot-prompt")
  public String fewShotPrompt() {
    return "few-shot-prompt";
  }  
  
  @GetMapping("/role-assignment")
  public String rollAssignment() {
    return "role-assignment";
  }   
  
}
