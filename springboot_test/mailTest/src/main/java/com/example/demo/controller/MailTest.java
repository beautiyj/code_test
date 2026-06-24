package springboot_test.mailTest.src.main.java.com.example.demo.controller;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class MailTest {

	@RequestMapping("/send.do")
	public String send(Model model) {

		Random random = new Random();
		int a = random.nextInt(100);

		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "실제아이디@naver.com";
		String hostSMTPpwd = "실제비번"; 		// 비밀번호 입력

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "실제아이디@naver.com";
		String fromName = "친절한 홍길동씨";
		String subject = "Overflow인증메일입니다.";

		// 받는 사람 E-Mail 주소
		String mail = "실제아이디@naver.com";

		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465);

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg("<p align = 'center'>Overflow에 오신것을 환영합니다.</p><br>" 
							 + "<div align='center'> 인증번호 : " + a + "</div>");
			email.send();
		} catch (Exception e) {
			System.out.println(e);
		}		
		model.addAttribute("result", "good~!!\n 등록된 E-Mail 확인");

		return "result";
	}
}

/*
 보안설정을 위해 별도 프로퍼티파일 혹은 어플리케이션-시크릿.yml 깃이그노어추가하고
 mail:
  smtp:
    host: smtp.naver.com
    port: 465
    username: 아이디
    password: 비번
    
 package com.example.demo.controller;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailTest {

	// 설정값을 멤버 변수로 선언하여 @Value 주입
	@Value("${mail.smtp.host}")
	private String hostSMTP;

	@Value("${mail.smtp.port}")
	private int port;

	@Value("${mail.smtp.username}")
	private String hostSMTPid;

	@Value("${mail.smtp.password}")
	private String hostSMTPpwd;

	@RequestMapping("/send.do")
	public String send(Model model) {

		Random random = new Random();
		int a = random.nextInt(100);

		// Mail Server 설정
		String charSet = "utf-8";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "실제아이디@naver.com";
		String fromName = "친절한 홍길동씨";
		String subject = "Overflow인증메일입니다.";

		// 받는 사람 E-Mail 주소
		String mail = "실제아이디@gmail.com";

		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP); // 주입받은 hostSMTP 사용
			email.setSmtpPort(port);     // 주입받은 port 사용

			email.setAuthentication(hostSMTPid, hostSMTPpwd); // 주입받은 id/pwd 사용
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg("<p align = 'center'>Overflow에 오신것을 환영합니다.</p><br>" 
							 + "<div align='center'> 인증번호 : " + a + "</div>");
			email.send();
		} catch (Exception e) {
			System.out.println(e);
		}		
		model.addAttribute("result", "good~!!\n 등록된 E-Mail 확인");

		return "result";
	}
}

 * */
