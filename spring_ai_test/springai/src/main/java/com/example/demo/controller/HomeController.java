package spring_ai_test.springai.src.main.java.com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// AI 챗봇 메인 페이지로 이동
	@GetMapping("/")
	public String main() {
		return "home";       
	}

}
