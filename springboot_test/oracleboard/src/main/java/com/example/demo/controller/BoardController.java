package springboot_test.oracleboard.src.main.java.com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

	@Autowired // 서비스 객체 의존성 주입
	private BoardService service;

	// @RequestMapping은 모든 요청 가능, @GetMapping은 겟 요청만 가능
	// 초기 요청
	@RequestMapping("/")
	public String main() {
		return "redirect:boardlist";
	}

	// 글작성 폼
	@RequestMapping("boardform")
	public String boardform() {
		return "board/boardform"; // http://localhost:9999/boardform
	}

	// 글작성 - DTO에 있는 필요 데이터를 받아옴
	@RequestMapping("boardwrite")
	public String boardwrite(@ModelAttribute Board board, Model model) {
//		System.out.println("===== 받은 board 데이터 =====");
		System.out.println(board);
//		System.out.println("=============================");

		int result = service.insert(board);
		if (result == 1) {
			System.out.println("글작성 성공");
		}

		// 값 넘겨주기 - 컨트롤러에서 처리한 데이터를 뷰(JSP)로 전달
		model.addAttribute("result", result);

		// 컨트롤러가 넘겨준 result 값을 받아서 성공/실패 메시지를 처리하는 파일
		return "board/insertresult";
	}

	// 글목록
	@RequestMapping("boardlist")
	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		int limit = 10; // 한 페이지에 출력할 데이터 개수
		int listcount = service.count(); // 총 데이터 개수
		System.out.println("listcount:" + listcount);

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		List<Board> boardlist = service.list(page);
		System.out.println("boardlist: " + boardlist);

		// 총 페이지 수
//		int pagecount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		int pagecount = (int) Math.ceil((double) listcount / limit);

		int startpage = ((page - 1) / 10) * limit + 1; // 1, 11, 21 ...
		int endpage = startpage + 10 - 1; // 10, 20, 30 ...

		// 마지막 블럭에 실제 존재하는 페이지만 출력
		if (endpage > pagecount) {
			endpage = pagecount;
		}

		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);

		return "board/boardlist";
	}

	// 상세페이지
	@RequestMapping("boardcontent")
	public String boardcontent(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {

		// 조회수 증가
		service.updatecount(no);

		// 상세정보 구하기
		Board board = service.content(no);
		String content = board.getContent().replace("\n", "<br>");

		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);

		return "board/boardcontent";
	}

	// 수정 폼
	@RequestMapping("boardupdateform")
	public String boardupdateform(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {

		// 상세정보 구하기
		Board board = service.content(no);
		String content = board.getContent().replace("\n", "<br>");
		
		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);
		
		
		return "board/boardupdateform";
	}

	// 글수정
	@RequestMapping("boardupdate")
	public String boardupdate(@ModelAttribute Board board,@RequestParam("page") int page, Model model) {

		int result = 0;

		// 비번 구하기
		Board db = service.content(board.getNo());
		
		// 비번 비교
		if (db.getPasswd().equals(board.getPasswd())) {
			result = service.update(board);
		} else {
			result = -1;
		}
		
		model.addAttribute("result", result);
		model.addAttribute("page", page);
		
		return "board/updateresult";
	}
	
	// 글 삭제 폼
	@RequestMapping("boarddeleteform")
	public String boarddeleteform(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {
		model.addAttribute("no", no);
		model.addAttribute("page", page);

		return "board/boarddeleteform";
	}
	
	// 글 삭제
	@RequestMapping("boarddelete")
	public String boarddelete(@ModelAttribute Board board,@RequestParam("page") int page, Model model) {
		int result = 0;

		// 비번 구하기
		Board db = service.content(board.getNo());

		// 비번 비교
		if (db.getPasswd().equals(board.getPasswd())) {
			result = service.delete(board.getNo());
		} else {
			result = -1;
		}
		
		model.addAttribute("result", result);
		model.addAttribute("page", page);

		return "board/deleteresult";
	}

	/*
	 * @GetMapping("/") public String home() { System.out.println("컨트롤러가 호출되었습니다");
	 * // 서버 확인용 로그 임시 추가해둠 return "index"; }
	 */
}