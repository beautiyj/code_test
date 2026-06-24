package springboot_test.sbboard.src.main.java.com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardDao dao;

	public int insert(Board board) {
		return dao.insert(board);
	}

	public int count() {
		return dao.count();
	}

	public List<Board> list(int page) {
		return dao.list(page);
	}

	public void hit(int board_num) {
		dao.hit(board_num);
	}

	public Board content(int board_num) {
		return dao.content(board_num);
	}

	public int reply(Board board) {
		
		// 1. 기존 댓글의 board_re_seq값 1증가
		dao.sequpdate(board);
		
		// 2. 댓글 작성
		board.setBoard_re_lev(board.getBoard_re_lev() + 1);  // 부모보다 1증가된 레벨 저장
		board.setBoard_re_seq(board.getBoard_re_seq() + 1);  // 부모보다 1증가된 seq 저장

		return dao.reply(board);
	}

	public int update(Board board) {
		return dao.update(board);
	}

	public int delete(int board_num) {
		return dao.delete(board_num);
	}
	
}



