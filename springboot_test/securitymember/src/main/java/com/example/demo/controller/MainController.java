package springboot_test.securitymember.src.main.java.com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/api")
public class MainController {

	@GetMapping("/main")
	public String main() {
		System.out.println("main Controller");
		return "main";
	}
	
	
}
