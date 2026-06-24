package springboot_test.springtest.src.main.java.com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HomeController {

	/*
	 * // 컨트롤러에 /WEB-INF/views/index.jsp 찾으라고 시켜야 브라우저에 뜸
	 * 
	 * @GetMapping("/") public String index() { return "index"; }
	 */
    @RequestMapping("/")
    public String hello() {
        return "JSP가 필요 없는 RestController";
    }
    
    @RequestMapping("/hi")
    public String hi() {
        return "JSP가 필요 없는 RestController _ hi로 이동";
    }
}
