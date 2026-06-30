package springboot_test.jpamysql2.src.main.java.com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import jakarta.servlet.http.HttpSession;
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

	@RequestMapping("/")
	public String main() {
		return "redirect:boardlist";
	}

	// 글작성 폼
	@RequestMapping("boardform")
	public String boardform() {
		return "boardform";
	}

	// 글 작성
	@RequestMapping("boardwrite")
	public String boardwrite(@ModelAttribute Board board, Model model) {

		int result = 0;
		Board db = service.save(board); // insert sql문 실행
		System.out.println("db: " + db);

		if (db != null) {
			result = 1;
		}

		model.addAttribute("result", result);

		return "insertresult";
	}

	// 글 목록
	@RequestMapping("boardlist")
	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model,
			HttpSession session) {
		// 한 페이지에 출력할 데이터 개수
		int limit = 10;

		// 레파지토리의 long형 count() 함수 활용. listcount는 총 데이터 개수
		int listcount = (int) service.count();
		System.out.println("listcount: " + listcount);

		// limit 추출할 시작 인덱스 번호, 추출할 데이터 개수
		// page = 1 : start = 0
		// page = 2 : start = 10
		// page = 3 : start = 20
		// start는 각 페이지 별 추출할 시작 번호 (0, 10, 20,...)
		int start = (page - 1) * limit;
		
		List<Board> boardlist = service.findAll(start);
		System.out.println("boardlist: " + boardlist);

		// 총 페이지
//		int pagecount = listcount / limit + ((listcount%limit == 0)?0:1);
		int pagecount = (int) Math.ceil((double) listcount / limit);

		int startpage = ((page - 1) / 10) * limit + 1; // 1, 11, 21...
		int endpage = startpage + 10 - 1; // 10, 20, 30...

		if (endpage > pagecount) {
			endpage = pagecount;
		}

		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);

		return "boardlist";
	}

	// 상세페이지
	@RequestMapping("boardcontent")
	public String boardcontent(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {

		// 상세정보 구하기
		Board board = service.findByNo(no);
		System.out.println("board : " + board);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "boardcontent";
	}

	// 글 수정 폼
	@RequestMapping("updateform")
	public String updateform(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {
		// 상세정보 구하기
		Board board = service.findByNo(no);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "updateform";
	}

	// 글 수정
	@RequestMapping("boardupdate")
	public String boardupdate(@ModelAttribute Board board, @RequestParam("page") int page, Model model) {

		// 비번 구하기 + 비번 비교
		Board db = service.findByNo(board.getNo());
		int result = 0;
		if (db.getPasswd().equals(board.getPasswd())) {
			// 폼에서 받은 값 중 수정 대상 필드만 db에 옮겨담기 (regdate는 그대로 유지됨)
			db.setWriter(board.getWriter());
			db.setSubject(board.getSubject());
			db.setContent(board.getContent());

			Board board2 = service.save(db); // update sql문 실행
			System.out.println("수정된 데이터 board2: " + board2);
			result = 1;
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page);

		return "updateresult";
	}

	// 글 삭제 폼
	@RequestMapping("deleteform")
	public String deleteform(@RequestParam("no") int no, @RequestParam("page") int page, Model model) {
		model.addAttribute("no", no);
		model.addAttribute("page", page);

		return "deleteform";
	}

	// 글 삭제
	@RequestMapping("boarddelete")
	public String boarddelete(@ModelAttribute Board board, @RequestParam("page") int page, Model model) {
		int result = 0;

		// 비번 구하기 + 비번 비교
		Board db = service.findByNo(board.getNo());

		if (db.getPasswd().equals(board.getPasswd())) {
			service.delete(board); // delete sql문 실행
			result = 1;
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page);

		return "deleteresult";
	}

//	@RequestMapping("/")
//	public String main() {
//		return "main";
//	}

//	@RequestMapping("/")
//	public String main() {
//		return "main";
//	}
}
