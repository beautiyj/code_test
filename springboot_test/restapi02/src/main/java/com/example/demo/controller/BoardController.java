package springboot_test.restapi02.src.main.java.com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 클래스에 @Controller를 붙이면, 이 컨트롤러가 반환하는 문자열은 기본적으로 '뷰(HTML 파일)의 이름'으로 인식
// 메서드마다 @ResponseBody를 붙여주면, "이 메서드는 HTML 뷰를 찾지 말고, 데이터 자체(JSON 등)를 응답해라"는 뜻
// RestController는 컨트롤러+리스폰스바디니까 리스폰스바디생략가능(있어도 오류는 안나지만 중복이라 불필요)
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl service;

	// main
	@GetMapping("/main")
	public String main() {
		return "main";
	}	
	
	// 글작성
	@PostMapping("/boardwrite")
	@ResponseBody
	public ResponseEntity<Integer> boardwrite(@RequestBody Board board) {
		System.out.println("boardwrite 진입");
		int result = service.insert(board);
		System.out.println("result:" + result);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 글목록
	@GetMapping("/boardlist/{page}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> boardlist(@PathVariable("page") int page) {
		int limit = 10;
		int listcount = service.getCount();
		System.out.println("listcount:" + listcount);
		List<Board> boardlist = service.getBoardList(page);
		System.out.println("boardlist:" + boardlist);
		// 총 페이지수
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		int startPage = ((page - 1) / 10) * limit + 1; 		// 1, 11, 21..
		int endPage = startPage + 10 - 1; 			   		// 10, 20, 30..
		if (endPage > pageCount)
			endPage = pageCount;
		Map map = new HashMap<>();
		map.put("page", page);
		map.put("listcount", listcount);
		map.put("boardlist", boardlist);
		map.put("pageCount", pageCount);
		map.put("startPage", startPage);
		map.put("endPage", endPage);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 상세페이지 : 조회수 1증가 + 상세정보 구하기
	@GetMapping("/boardcontent/{no}/{page}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> boardcontent(@PathVariable("no") int no, 
							  								@PathVariable("page") int page) {
		service.updatecount(no); 				// 조회수 1증가
		Board board = service.getBoard(no); 	// 상세정보 구하기
		String content = board.getContent().replace("\n", "<br>");

		Map map = new HashMap<>();
		map.put("board", board);
		map.put("content", content);
		map.put("page", page);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 수정 폼
	@GetMapping("/updateform/{no}/{page}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> boardupdateform(@PathVariable("no") int no, 
								 							   @PathVariable("page") int page) {
		System.out.println("수정폼 진입");
		System.out.println("no:"+no);
		System.out.println("page:"+page);
		
		Board board = service.getBoard(no); 	// 상세정보 구하기
		
		Map map = new HashMap<>();
		map.put("board", board);
		map.put("page", page);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 글수정
	@PutMapping("/boardupdate/{page}")
	@ResponseBody
	public ResponseEntity<Integer> boardupdate(@PathVariable("page") int page, 
							   		  		   @RequestBody Board board) {
		int result = 0;
		Board old = service.getBoard(board.getNo());
		if (old.getPasswd().equals(board.getPasswd())) { 	// 비번일치
			result = service.update(board);
		} else { 											// 비번 불일치
			result = -1;
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 삭제 폼
	@GetMapping("/deleteform/{no}/{page}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteform(@PathVariable("no") int no,
							 							  @PathVariable("page") int page) {
		Map map = new HashMap<>();
		map.put("no", no);
		map.put("page", page);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 글삭제
	@DeleteMapping("/boarddelete/{page}")
	@ResponseBody
	public ResponseEntity<Integer> boarddelete(@PathVariable("page") int page, 
								   			   @RequestBody Board board) {
			int result = 0;
			Board old = service.getBoard(board.getNo());
			if (old.getPasswd().equals(board.getPasswd())) { 	// 비번일치
				result = service.delete(board.getNo());
			} else { 											// 비번 불일치
				result = -1;
			}

			return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
