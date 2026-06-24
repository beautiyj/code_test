package springboot_test.oracleboard3.src.main.java.com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao; // 서비스에서 컨트롤러 명령 받고 DAO 호출, 데이터를 가져옴

	public int insert(Board board) {
		return dao.insert(board);
	}

	// 검색 기능 추가하면서 보드 추가
	public int count(Board board) {
		return dao.count(board);
	}

	// 검색 기능 추가하면서 보드 추가
	public List<Board> list(Board board) {
		return dao.list(board);
	}

	public void updatecount(int no) {
		dao.updatecount(no);
	}

	public Board content(int no) {
		return dao.content(no);
	}

	public int update(Board board) {
		return dao.update(board);
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}
}
