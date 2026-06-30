package springboot_test.jpaoracle2.src.main.java.com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

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
}
