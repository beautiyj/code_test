package springboot_test.restapi01.src.main.java.com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController		// 전부 비동기식으로 진행
@CrossOrigin("*")	// cors 문제 해결용 어노테이션(혹은 config 폴더 방식도 가능. 예시로 2가지 모두 진행)
public class HomeController {
	
	@RequestMapping("/sample")
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		return sv;
	}

	@RequestMapping("/list")
	public List<SampleVo> list() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		for (int i = 1; i <= 10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			list.add(sv);
		}
		return list;
	}
	
	// register 와 register2는 리액트나 AJAX 측에서 JSON 데이터{ "mno": 1, ... }를 보낼 때, 받아주는 통로 역할
	// 매개변수 앞에 붙은 @RequestBody가 그 JSON을 자바 객체(SampleVo)로 변환해 주는 역할
	@RequestMapping("/register")
	public Integer register(@RequestBody SampleVo sv) {
		System.out.println("mno:"+ sv.getMno());
		System.out.println("firstName:"+ sv.getFirstName());
		System.out.println("lastName:"+ sv.getLastName());
		
		int result = 1;
		
		return result;
	}
	/*
	 프론트엔드 파일5에서 리액트파일 실행하면
	 스프링부트의 콘솔창에
	 mno:30
	 firstName:김
	 lastName:길동
	 이렇게 회원가입 정보 뜸(데이터 확인 가능)
	 */
	
	@RequestMapping("/register2")
	public Integer register2(@RequestBody SampleVo sv) {
		System.out.println("mno:"+ sv.getMno());
		System.out.println("firstName:"+ sv.getFirstName());
		System.out.println("lastName:"+ sv.getLastName());
		
		int result = 1;
		
		return result;
	}
	/*
	 프론트엔드 파일6에서 리액트파일 실행 -> 브라우저에 데이터 입력하면
	 스프링부트의 콘솔창에 입력한 값대로 뜸. 순서대로 111,222,333을 입력했을 경우
	 mno:111
	 firstName:222
	 lastName:333
	 이렇게 입력한 데이터의 정보 뜸(데이터 확인 가능)
	 */
	
}
