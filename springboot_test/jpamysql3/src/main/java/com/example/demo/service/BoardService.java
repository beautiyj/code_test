package springboot_test.jpamysql3.src.main.java.com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository repository;

	public Board save(Board board) {
		return repository.save(board);
	}

	public long count() {
		return repository.count();
	}

//	public List<Board> findAll(int page) {
//		return repository.findAll(page);
//	}

	public Board findByNo(int no) {
		return repository.findByNo(no);
	}
	
	public void delete(Board board) {
		repository.delete(board);
	}

	public int searchCount(String search, String keyword) {
		return repository.searchCount(search, keyword);
	}

	public int getCount() {
		return repository.getCount();
	}

	public List<Board> searchList(int start, String search, String keyword) {
		return repository.searchList(start, search, keyword);
	}
	
	public List<Board> getList(int start) {
		return repository.getList(start);
	}
}
