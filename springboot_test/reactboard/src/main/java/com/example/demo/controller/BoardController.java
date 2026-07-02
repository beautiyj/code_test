package springboot_test.reactboard.src.main.java.com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Board;
import com.example.demo.service.BoardService;

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
		if(result == 1) System.out.println("글작성 성공");
		
		return result;
	}
	
	// 글목록
	@GetMapping("boardlist")
	public List<Board> boardlist() {
		
		List<Board> boardlist = service.getBoardList();
		System.out.println("boardlist:"+ boardlist);
		
		return boardlist;
	}
	
	
}




