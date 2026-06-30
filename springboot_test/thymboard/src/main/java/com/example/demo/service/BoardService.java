package springboot_test.thymboard.src.main.java.com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.model.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	// 다오 객체 주입
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

	public int updatecount(int no) {
		return dao.updatecount(no);
	}
	
	public Board content(int no) {
		return dao.content(no);
	}

	public int update(Board board) {
		return dao.update(board);
	}
	
}
