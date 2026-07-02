package springboot_test.reactboard.src.main.java.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;

	public int insert(Board board) {
		return dao.insert(board);
	}	

	public List<Board> getBoardList() {
		return dao.getBoardList();
	}

	
}



