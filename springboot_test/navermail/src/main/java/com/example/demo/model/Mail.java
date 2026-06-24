package springboot_test.navermail.src.main.java.com.example.demo.model;

import lombok.Data;

@Data
public class Mail {

	private String sendmail;
	private String receivedmail;
	private String subject;
	private String content;
	
}
