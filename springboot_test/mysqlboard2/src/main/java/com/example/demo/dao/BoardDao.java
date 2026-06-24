package springboot_test.mysqlboard2.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    int insert(Board board);
	// 검색 기능 추가하면서 보드 추가
    int count(Board board);
    // page -> start 변경, start -> board 변경(검색 기능)
    List<Board> list(Board board);
    
    void updatecount(int no);
    Board content(int no);
    int update(Board board);
    int delete(int no);
}