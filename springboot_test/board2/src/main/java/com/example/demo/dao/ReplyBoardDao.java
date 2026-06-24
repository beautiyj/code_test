package springboot_test.board2.src.main.java.com.example.demo.dao;

import com.example.demo.model.ReplyBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyBoardDao {
	
	List<ReplyBoard> list(int num);
	void insert(ReplyBoard rb);
	void delete(int rno);
	void update(ReplyBoard rb);
	
}