package springboot_test.mysqlboard.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    int insert(Board board);
    int count();
    // page -> start 변경
    List<Board> list(int start);
    void updatecount(int no);
    Board content(int no);
    int update(Board board);
    int delete(int no);
}