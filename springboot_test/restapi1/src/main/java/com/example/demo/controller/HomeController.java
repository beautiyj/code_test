package springboot_test.restapi1.src.main.java.com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("*")
public class HomeController {

	// 동기식(@ResponseBody 없음)
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	// 비동기식
	@GetMapping("sample")
	@ResponseBody                    // 요청한 곳에 값을 돌려주는 역할
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		return sv;
	}
	
	// 비동기식
	@GetMapping("list")
	@ResponseBody
	public List<SampleVo> list(){
		List<SampleVo> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			
			list.add(sv);
		}
		return list;
	}
	
	
	
}





