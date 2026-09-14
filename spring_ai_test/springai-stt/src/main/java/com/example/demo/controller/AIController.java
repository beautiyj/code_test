package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.AiService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AIController {
  
  @Autowired
  private AiService aiService;

  //1. STT
  @PostMapping(
    value = "/stt", 
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
    produces = MediaType.TEXT_PLAIN_VALUE            
  )
  public String stt(@RequestParam("speech") MultipartFile speech) throws IOException {
	  String originalFileName = speech.getOriginalFilename();
	  byte[] bytes = speech.getBytes();    // MultipartFile에서 음성 데이터를 바이트 배열로 가져옴
	  String text = aiService.stt(originalFileName, bytes);
	  return text;
  }

  //2. TTS
  @PostMapping(
    value = "/tts", 
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,  // 요청 본문이 application/x-www-form-urlencoded 형식임을 명시
    produces = MediaType.APPLICATION_OCTET_STREAM_VALUE      // 응답 본문이 바이너리 데이터임을 명시
  )
  public byte[] tts(@RequestParam("text") String text) {
    byte[] bytes = aiService.tts(text);
    return bytes;
  }

  
  //3. STT + LLM + TTS
  @PostMapping(
    value = "/chat-text", 
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Map<String, String> chatText(@RequestParam("question") String question) {
    Map<String, String> response = aiService.chatText(question);
    return response;
  }

  
  //4. STT + LLM + TTS (비동기 스트리밍)
  @PostMapping(
    value = "/chat-voice-stt-llm-tts", 
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
    produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
  )
  public void chatVoiceSttLlmTts(
    @RequestParam("question") MultipartFile question, 
    HttpServletResponse response) throws Exception {
    // 비동기 음성 데이터를 Flux<byte[]>을 얻기
    Flux<byte[]> flux = aiService.chatVoiceSttLlmTts(question.getBytes());

    // 음성 데이터를 응답 본문으로 스트림 출력
    OutputStream outputStream = response.getOutputStream();
    
    for (byte[] chunk : flux.toIterable()) {
      outputStream.write(chunk);
      outputStream.flush();
    }
  }

  //4. STT + LLM + TTS (비동기 스트리밍) - StreamingResponseBody 사용
  // @PostMapping(
  //   value = "/chat-voice-stt-llm-tts", 
  //   consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
  //   produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
  // )
  // public StreamingResponseBody chatVoiceSttLlmTts(
  //     @RequestParam("question") MultipartFile question,
  //     HttpServletResponse response) throws Exception {
  //   // 비동기 음성 데이터를 Flux<byte[]>을 얻기
  //   Flux<byte[]> flux = aiService.chatVoiceSttLlmTts(question.getBytes());

  //   // 음성 데이터를 응답 본문으로 스트림 출력
  //   StreamingResponseBody srd = new StreamingResponseBody() {
  //     @Override
  //     public void writeTo(OutputStream outputStream) throws IOException {
  //       for (byte[] chunk : flux.toIterable()) {
  //         outputStream.write(chunk);
  //         outputStream.flush();
  //       }
  //     }
  //   };    
  //   return srd;
  // }

  
  //5. 순수 음성 대화 (STT + LLM + TTS를 하나의 모델로 처리)
  @PostMapping(
    value = "/chat-voice-one-model", 
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
    produces = MediaType.APPLICATION_OCTET_STREAM_VALUE    // 응답 본문이 바이너리 데이터임을 명시
  )
  public byte[] chatVoiceOneModel(
    @RequestParam("question") MultipartFile question,
    HttpServletResponse response) throws Exception {
    byte[] bytes = aiService.chatVoiceOneModel(question.getBytes(), question.getContentType());
    return bytes;
  }
  
}
