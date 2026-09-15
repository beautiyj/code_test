package com.gnagnoohc.bootone.controller;

import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin; // 추가
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "http://localhost:3000") // 리액트(3000) 요청 허용
public class SampleController {
	
	@RequestMapping("/")
	@ResponseBody // JSP 대신 데이터로 반환
	public String main() {
		return "main";
	}
	
	@RequestMapping("/hi")
	@ResponseBody
	public void hello(HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello world~!!!");
	}

	@RequestMapping("/abc")
	@ResponseBody
	public String abc() {
		return "hi abc";
	}

	@RequestMapping("/hello")
	@ResponseBody // JSP 대신 데이터로 반환
	public String hello() {
		return "hello";
	}

	@RequestMapping("/gugu")
	@ResponseBody // JSP 대신 데이터로 반환
	public String gugu() {
		Random r = new Random();
		int dan = r.nextInt(8) + 2;
		return String.valueOf(dan); // JSP 모델 대신 데이터 반환
	}
}