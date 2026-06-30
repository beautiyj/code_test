package springboot_test.thymboard.src.main.java.com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Board;

@Mapper
public interface BoardDao {

	// 추상메소드. 값을 받을 때는 파라미터타입으로(매퍼파일 보드.xml)
	int insert(Board board);

	int count();

	List<Board> list(int page);

	int updatecount(int no);

	Board content(int no);

	int update(Board board);


}
