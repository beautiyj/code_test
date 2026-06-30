package springboot_test.jpaoracle3.src.main.java.com.example.demo.service;

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

	public List<Board> findAll(int page) {
		return repository.findAll(page);
	}

	public Board findByNo(int no) {
		return repository.findByNo(no);
	}

	public void delete(Board board) {
		repository.delete(board);
	}

	// 검색 데이터 개수
	public int searchCount(String search, String keyword) {
		return repository.searchCount(search, keyword);
	}

	public int getCount() {
		return repository.getCount();
	}

	// 만약 기존 코드인 findAll(page) 활용하는 경우 매개변수에 start, end 추가 필요(컨트롤러의 주석코드 77줄)
	public List<Board> searchList(String search, String keyword) {
		return repository.searchList(search, keyword);
	}

	public List<Board> getList(int start, int end) {
		return repository.getList(start, end);
	}
}
