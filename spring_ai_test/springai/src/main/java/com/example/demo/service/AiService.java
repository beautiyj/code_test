package spring_ai_test.springai.src.main.java.com.example.demo.service;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

// 스프링부트에서 ChatModel 인터페이스 자체를 전체 공통 규격 추상화로 만들어둔 상태라서 ai지원하는 건 전부 형태 동일하게 함수 작성 가능
@Service
public class AiService {
	@Autowired
	private ChatModel chatModel;

//	사용자 질문에 대해 답변을 생성하는 메서드
	
//	1. chat방식	
//	public String generateText(String question) {
// 	2. flux방식
	public Flux<String> generateStreamText(String question) {

//		1. 시스템 메세지 생성 
//		: 시스템 메세지는 모델에게 대화의 맥락을 제공하고, 모델이 어떻게 응답해야 하는지 지시하는 역할
		SystemMessage systemMessage = SystemMessage.builder()
			.text("사용자 질문에 대해 한국어로 답변을 해야합니다.")
			.build();

//		2. 사용자 메세지 생성
//		: 사용자 메세지는 실제로 사용자가 모델에게 전달하는 질문이나 요청을 의미함
		UserMessage userMessage = UserMessage.builder()
			.text(question)
			.build();

//		3. 대화 옵션 설정
//		: ChatOptions는 모델의 동작을 제어하는 다양한 설정을 포함함
		ChatOptions chatOptions = ChatOptions.builder()
//			.model("gpt-5-nano") 		// 사용할 모델 설정하면 됨
//			.model("gpt-4o-mini")		// OPEN AI의 경우 해당 모델 사용하기
			.model("gemini-2.5-flash")	// GEMINI AI의 경우 이걸로. 260630기준 2.5만 지원함
			.temperature(0.3) 			// 응답의 창의성 설정(0.0 ~ 1.0)
//			.maxTokens(1000) 			// 최대 토큰 수 설정
			.build();

//		4. 프롬프트 생성
//		: Prompt는 시스템 메세지, 사용자 메세지, 대화 옵션을 포함하여 모델에게 전달할 전체 입력을 구성함
		Prompt prompt = Prompt.builder()
							  .messages(systemMessage, userMessage)
							  .chatOptions(chatOptions).build();

//		5. LLM에게 요청하고 응답받기
//		: chatModel.call() 메서드를 사용하여 프롬프트를 전달하고, 모델의 응답을 ChatResponse 객체로 받음
//		ChatResponse chatResponse = chatModel.call(prompt);
		
// 		5. flux방식으로 진행할 때		
//		chatModel.stream() 메서드를 사용하여 프롬프트를 전달하고, 모델의 응답을 ChatResponse 객체로 받음
		Flux<ChatResponse> fluxResponse = chatModel.stream(prompt);

//		6. 모델의 응답에서 실제 답변 추출
//		AssistantMessage assistantMessage = chatResponse.getResult().getOutput();
//		AssistantMessage는 모델이 생성한 답변을 포함하며, getText() 메서드를 통해 실제 텍스트를 얻을 수 있음
//		String answer = assistantMessage.getText();
//		return answer;
//	}
	
//		6. flux방식으로 진행할 때			
//		6. 응답에서 텍스트 부분만 추출하여 Flux<String>으로 변환
		Flux<String> fluxString = fluxResponse.map(chatResponse-> {
		// 응답에서 어시스턴트 메시지 추출
		AssistantMessage assistantMessage = chatResponse.getResult().getOutput();
		String chunk = assistantMessage.getText();
		// chunk - flux타입의 가이드 참고 (Spring ai 폴터 3번 pdf)
		if (chunk == null) chunk = "";              
			return chunk;
		});
		return fluxString;
	}
}
