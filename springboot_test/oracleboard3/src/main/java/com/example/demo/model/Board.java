package springboot_test.oracleboard3.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("board")		// board만 적어도 DTO객체 받을 수 있게 별칭 설정
public class Board {
	private int no;
	private String writer;
	private String passwd;
	private String subject;
	private String content;
	private int readcount;
	private Date register;
	
	// 검색기능을 위해 추가
	
	// page
	private int startRow;
	private int endRow;
	
	// 검색
	private String search;
	private String keyword;
}