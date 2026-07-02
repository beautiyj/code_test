package springboot_test.reactboard2.src.main.java.com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.Board;

@Mapper
public interface BoardDao {

	int insert(Board board);	
	List<Board> getBoardList();

}





