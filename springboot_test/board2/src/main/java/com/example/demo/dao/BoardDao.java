package springboot_test.board2.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
	
	List<Board> list(Board board);	
	int getTotal(Board board);	
	int insert(Board board);	
	Board select(int num);	
	void selectUpdate(int num);	
	int update(Board board);	
	int delete(int num);	
	int getMaxNum();	
	void updateRe(Board board);
	
}