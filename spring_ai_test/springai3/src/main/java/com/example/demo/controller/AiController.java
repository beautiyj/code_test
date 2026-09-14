package spring_ai_test.springai3.src.main.java.com.example.demo.controller;

import com.example.demo.service.AiServiceByChatClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiController {
  
   @Autowired
   private AiServiceByChatClient aiService;

  // 질문에 대한 답변을 문자로 생성하는 요청 
  @PostMapping(
    value = "/chat-model",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE             //일반 텍스트
  )
  public String chatModel(@RequestParam("question") String question) {
    String answerText = aiService.generateText(question);
    return answerText;
  }

  
  // 질문에 대한 답변을 스트리밍으로 생성하는 요청
  // 0730 제미나이API로했을때,스트리밍방식이 청크방식(바로바로실시간채팅문장하나씩나옴)이아닌 통으로나오는문제미해결상태
  @PostMapping(
    value = "/chat-model-stream",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//    produces = MediaType.APPLICATION_NDJSON_VALUE      //라인으로 구분된 청크 텍스트
    produces = MediaType.TEXT_EVENT_STREAM_VALUE   // x-ndjson 대신 SSE(text/event-stream) 표준 규격으로 변경!
  )
  public Flux<String> chatModelStream(@RequestParam("question") String question) {
    Flux<String> answerStreamText = aiService.generateStreamText(question);
    return answerStreamText;
  }
  
}
