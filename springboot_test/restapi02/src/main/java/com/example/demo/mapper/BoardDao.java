package springboot_test.restapi02.src.main.java.com.example.demo.mapper;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

	public int insert(Board board);

	public int getCount();

	public List<Board> getBoardList(int page);

	public void updatecount(int no);

	public Board getBoard(int no);

	public int update(Board board);

	public int delete(int no);

}
