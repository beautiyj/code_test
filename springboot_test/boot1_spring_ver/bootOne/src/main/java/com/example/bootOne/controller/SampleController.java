package springboot_test.boot1_spring_ver.bootOne.src.main.java.com.example.bootOne.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Random;

// @RestController = @Controller + @ResponseBody 역할ㄴ
@Controller
public class SampleController {
	
	// jsp가 있어야 출력됨 - 화면(JSP) 출력용
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	// @ResponseBody 어노테이션이 있음, jsp없어도 출력됨
	// 이 메서드가 리턴하는 결과물(또는 이 안에서 직접 처리하는 내용)을
	// JSP 같은 파일로 연결하지 말고 브라우저에 데이터(본문) 그대로 출력하라는 명령
	@RequestMapping("/hi")
	@ResponseBody
	public void hello(HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello world~!!!");
	}

	// @ResponseBody 어노테이션이 있음, jsp없어도 출력됨
	@RequestMapping("/abc")
	@ResponseBody
	public String abc() {
		return "hi abc";
	}

	// jsp가 있어야 출력됨 - http://localhost:9999/hello의 화면(JSP) 출력용
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	// jsp가 있어야 출력됨 - http://localhost:9999/gugu의 화면(JSP) 출력용
	// 모델 객체는 값을 가져갈 때만 사용(값 담아서 전달할 때)
	// model.addAttribute("dan", dan)를 통해 데이터를 바구니(모델)에 담고
	// 컨트롤러가 gugu 리턴하면 -> gugu.jsp를 찾아서 데이터 전달,
	// jsp는 전달 받은 모델 바구니에서 dan이라는 이름으로 저장된 값을 꺼내서 화면에 출력
	@RequestMapping("/gugu")
	public String gugu(Model model) {
		Random r = new Random();
		int dan = r.nextInt(8) + 2;				// 2 ~ 9단
		model.addAttribute("dan", dan);
		return "gugu";
	}
}




