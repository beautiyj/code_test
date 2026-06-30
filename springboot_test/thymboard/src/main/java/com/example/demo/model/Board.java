package springboot_test.thymboard.src.main.java.com.example.demo.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드를 포함한 생성자
@NoArgsConstructor  // 기본 생성자
@Alias("board")
public class Board {
    private int no;          // 글번호
    private String writer;   // 작성자
    private String passwd;   // 비밀번호
    private String subject;  // 제목
    private String content;  // 내용
    private int readCount;   // 조회수 (테이블의 readcount)
    private Timestamp register; // 작성일 (테이블의 register)
}