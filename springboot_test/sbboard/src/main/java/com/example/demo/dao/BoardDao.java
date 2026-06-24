package springboot_test.sbboard.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

	int insert(Board board);

	int count();

	List<Board> list(int page);

	void hit(int board_num);

	Board content(int board_num);

	void sequpdate(Board board);

	int reply(Board board);

	int update(Board board);

	int delete(int board_num);

}



