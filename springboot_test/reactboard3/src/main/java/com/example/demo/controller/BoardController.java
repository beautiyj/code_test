package springboot_test.reactboard3.src.main.java.com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class BoardController {

	@Autowired
	private BoardService service;

	// 글작성
	@PostMapping("boardwrite")
	public Integer boardwrite(@RequestBody Board board) {
		System.out.println("controller in");
		System.out.println(board);

		int result = service.insert(board);
		if (result == 1)
			System.out.println("글작성 성공");

		return result;
	}

	// 글목록
	@GetMapping("boardlist")
	public Map<String, Object> boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		int limit = 10;
		int listcount = service.count();
		System.out.println("listcount:" + listcount);

		List<Board> boardlist = service.list(page);
		System.out.println("boardlist:" + boardlist);

		int pagecount = listcount / limit + ((listcount % 10 == 0) ? 0 : 1);
		int startpage = ((page - 1) / 10) * limit + 1; // 1, 11, 21...
		int endpage = startpage + 10 - 1; // 10, 20, 30...

		if (endpage > pagecount)
			endpage = pagecount;

		Map map = Map.of("page", page, "listcount", listcount, "boardlist", boardlist, "pagecount", pagecount,
				"startpage", startpage, "endpage", endpage);

		return map;
	}

	// 상세 페이지
	@GetMapping("boardcontent/{no}")
	public Board boardcontent(@PathVariable("no") int no) {
		System.out.println(no);

		Board result = service.content(no);
		System.out.println("detail result:" + result);

		return result;
	}

	// 수정폼
	@GetMapping("boardupdateform/{no}")
	public Board boardupdateform(@PathVariable("no") int no) {
		System.out.println(no);

		Board result = service.content(no);
		System.out.println("updateform result:" + result);

		return result;
	}

	// 글수정
	@PutMapping("boardupdate")
	public Integer boardupdate(@RequestBody Board board) {
		System.out.println("update board:" + board);

		int result = service.update(board);
		if (result == 1)
			System.out.println("글수정 성공");

		return result;
	}

	// 글삭제폼
	@GetMapping("boarddeleteform/{no}")
	public Board boarddeleteform(@PathVariable("no") int no) {
		System.out.println(no);

		Board result = service.content(no);
		System.out.println("updateform result:" + result);

		return result;
	}

	// 글삭제
	@DeleteMapping("boarddelete/{no}")
	public Integer boarddelete(@PathVariable("no") int no) {
		System.out.println("delete no:" + no);

		int result = service.delete(no);
		if (result == 1)
			System.out.println("글삭제 성공");

		return result;
	}

}
