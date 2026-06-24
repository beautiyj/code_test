package springboot_test.oracleboard2.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 인터페이스로 변환
/* 인터페이스로 변환 시 변경되는 파일은 2곳

Java 코드 (DAO 파일): 구현 클래스(BoardDaoImpl 등)를 지우고
				   메서드 정의만 남은 인터페이스(interface BoardDao)로 변경
XML 파일 (Mapper): XML 파일 내부의 <mapper namespace="..."> 속성에
				  인터페이스의 풀 패키지 경로로 변경
 * */
@Mapper
public interface BoardDao {

    int insert(Board board);
    int count();
    List<Board> list(int page);
    void updatecount(int no);
    Board content(int no);
    int update(Board board);
    int delete(int no);
}