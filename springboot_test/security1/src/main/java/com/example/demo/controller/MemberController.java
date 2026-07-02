package springboot_test.security1.src.main.java.com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

	@GetMapping("/member/list")
	public String getMember(Model model) {
		List<Member> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Member member = new Member();
			member.setName("홍길동" + i);
			member.setEmail("hong" + i + "@naver.com");
			list.add(member);
		}
		model.addAttribute("list", list);
		return "member/list";
		// http://localhost:9999/logout 로 들어가면 로그아웃됨!
	}

}
