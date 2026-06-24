package springboot_test.board1.src.main.java.com.example.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.Board;

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