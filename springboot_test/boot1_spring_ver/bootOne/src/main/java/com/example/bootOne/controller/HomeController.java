package springboot_test.boot1_spring_ver.bootOne.src.main.java.com.example.bootOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot<br>"
				+ "스프링부트 홈컨트롤러 코드";
	}
}
