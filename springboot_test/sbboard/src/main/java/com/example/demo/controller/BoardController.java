package springboot_test.sbboard.src.main.java.com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService service;
	
	// 초기요청
	@RequestMapping("/")
	public String main() {
		return "redirect:boardlist";      // boardlist 요청
	}
	
	// 원문작성폼
	@RequestMapping("boardform")
	public String boardform() {
		return "board/boardform";
	}
	
	// 글작성(원문)
	@RequestMapping("boardwrite")
	public String boardwrite(Board board, Model model) {
		int result = service.insert(board);		// insert sql문 실행
		if(result == 1) System.out.println("글작성 성공");
		
		model.addAttribute("result", result);
		
		return "board/insertresult";
	}
	
	// 글목록
	@RequestMapping("boardlist")
	public String boardlist(@RequestParam(value="page", defaultValue="1") int page,
							Model model) {
		
		int limit = 10;									// 한 페이지에 출력할 데이터 갯수
		int listcount = service.count();				// 데이터 갯수
		System.out.println("listcount:"+ listcount);
		
		List<Board> boardlist = service.list(page);		 // 데이터 목록
		System.out.println("boardlist:"+ boardlist);
		
		// 총 페이지
		int pagecount = listcount / limit + ((listcount % 10 == 0) ? 0 :  1);
		
		int startpage = ((page - 1) / 10) * limit + 1;		//  1, 11, 21...
		int endpage = startpage + 10 - 1;					// 10, 20, 30...
		
		if(endpage > pagecount)  endpage = pagecount;
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		
		return "board/boardlist";
	}
	
	// 상세 페이지, 댓글폼, 수정폼, 삭제폼  
	@RequestMapping("boardcontent")
	public String boardcontent(@RequestParam("board_num") int board_num,
							   @RequestParam("page") String page,
							   @RequestParam("state") String state,
							   Model model) {
		
		// state의 reply, cont 등의 사용자 지정 변수는 jsp에서 상태 관련으로 지정한 거라서
		// 각기 boardlist.jsp와 boardcontent.jsp 등에서
		// state=cont 형태로 선언..?함. 어디서 온 변수인가 헷갈릴까봐 적어둠
		
		if(state.equals("cont")) {           // 상세 페이지
			service.hit(board_num);          // 조회수 증가
		}
		
		Board board = service.content(board_num);   // 상세정보 구하기
		
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		if(state.equals("cont")) {				// 상세 페이지
			String content = board.getBoard_content().replace("\n", "<br>");
			model.addAttribute("content", content);
			
			return "board/boardcontent";
		}else if(state.equals("reply")) {		// 댓글폼

			return "board/boardreplyform";
		}else if(state.equals("edit")) {		// 수정폼
		
			return "board/boardupdateform";
		}else if(state.equals("del")) {			// 삭제폼
			
			return "board/boarddeleteform";
		}			
		return null;
	}
	
	// 댓글 작성
	@RequestMapping("boardreply")
	public String boardreply(@ModelAttribute Board board,
						     @RequestParam("page") String page,
						     Model model) {
		
		int result = service.reply(board);		
		
		model.addAttribute("result", result);
		model.addAttribute("page", page);
		
		return "board/replyresult";
	}
	
	// 글수정
	@RequestMapping("boardupdate")
	public String boardupdate(@ModelAttribute Board board,
		     				  @RequestParam("page") String page,
		     				  Model model) {
		
		int result = 0;
		
		Board db = service.content(board.getBoard_num());   	// 상세 정보 구하기
		
		// 비번 비교
		if(db.getBoard_pass().equals(board.getBoard_pass())) {  // 비번 일치시
			result = service.update(board);		// update sql문 실행
			
		}else {
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page);
		
		return "board/updateresult";
	}
	
	// 글삭제
	@RequestMapping("boarddelete")
	public String boarddelete(@ModelAttribute Board board,
						      @RequestParam("page") String page,
						      Model model) {
		
		int result = 0;
		Board db = service.content(board.getBoard_num());	     // 상세정보 구하기
		
		// 비번 비교
		if(db.getBoard_pass().equals(board.getBoard_pass())) {   // 비번 일치시
			result = service.delete(board.getBoard_num());       // delete sql문 실행
		}else {
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page);
		
		return "board/deleteresult";
	}
	
	
	
	
	
	
	
}
