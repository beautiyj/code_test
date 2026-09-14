package spring_ai_test.springai.src.main.java.com.example.demo.controller;

import com.example.demo.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {
	
	@Autowired
	private AiService aiService;
	
	// 1. chat방식 사용
	// AI 챗봇과의 대화를 처리하는 메서드
//	@PostMapping(value="/chat",
//		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, // 폼 데이터로 요청을 받을 때 사용
//		produces = MediaType.TEXT_PLAIN_VALUE)  				 // 클라이언트에게 JSON 형식으로 응답을 보낼 때 사용
//	public String chat(@RequestParam("question") String question) {
//		System.out.println("chatting...");
//		System.out.println("question : " + question);
//		
//		// AI 서비스에 질문을 전달하고 답변을 받음
//		String answerTest = aiService.generateText(question);		
//		System.out.println("answerTest : " + answerTest);		
//		
//		return answerTest;
//	}
	
	// 2. flux방식 사용
	@PostMapping(value = "/chat-stream", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,  // 폼 데이터로 요청을 받음
		produces = MediaType.APPLICATION_NDJSON_VALUE) // 응답은 NDJSON 형식으로 스트리밍

	// 질문을 받아서 AI 챗봇이 답변을 스트리밍으로 생성하여 반환
	public Flux<String> chatModelStream(@RequestParam("question") String question) {
		Flux<String> answerStreamText = aiService.generateStreamText(question);
		return answerStreamText;
	}
}
