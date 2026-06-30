package springboot_test.thymboard.src.main.java.com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	// 서비스 객체 주입
	private final BoardService service;

	// 초기 요청
	@RequestMapping("/")
	public String main() {
		return "redirect:boardlist";
	}

	// 글 작성 폼
	@RequestMapping("boardform")
	public String boardform() {
		return "board/boardform";
	}

	// 글 작성
	@RequestMapping("boardwrite")
	public String boardwrite(@ModelAttribute Board board, Model model) {
		int result = service.insert(board);
		if (result == 1) {
			System.out.println("글 작성 성공");
		}
		model.addAttribute("result", "result");

		return "board/insertresult";
	}

	// 글 목록
	@RequestMapping("boardlist")
	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		int limit = 10;
		int listcount = service.count();
		System.out.println("listcount: " + listcount);

		List<Board> boardlist = service.list(page);
		System.out.println("boardlist: " + boardlist);
		// 총 페이지
//			int pagecount = listcount / limit + ((listcount % 10 == 0) ? 0 : 1);
		int pagecount = (int) Math.ceil((double) listcount / limit);

		int startpage = ((page - 1) / 10) * limit + 1;
		int endpage = startpage + 10 - 1;

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

	// 상세페이지 : 조회수 1 증가, 상세정보 구하기
	@RequestMapping("boardcontent")
	public String boardcontent(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {

		service.updatecount(no);
		Board board = service.content(no);

		String content = board.getContent().replace("\n", "<br>");

		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);

		return "board/boardcontent";
	}

	// 글 수정 폼
	@RequestMapping("boardupdateform")
	public String boardupdateform(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {

		// 상세정보 구해오기
		Board board = service.content(no);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "board/boardupdateform";
	}

	// 글 수정
	@RequestMapping("boardupdate")
	public String boardupdate(@ModelAttribute Board board, @RequestParam("page") int page, Model model) {

		Board db = service.content(board.getNo());

		int result = 0;
		
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

//	@RequestMapping("boarssdform")
//	public String boardtform() {
//
//		return "board/ww";
//	}

//	@RequestMapping("index")
//	public String index() {
//		return "index";
//	}

}
