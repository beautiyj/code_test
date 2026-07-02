package springboot_test.reactboard3.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

	int insert(Board board);	
	int count();
	List<Board> list(int page);
	Board content(int no);
	int update(Board board);
	int delete(int no);

}





