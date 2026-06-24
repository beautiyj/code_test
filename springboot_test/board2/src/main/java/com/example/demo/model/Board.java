package springboot_test.board2.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("board")
public class Board {
	
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int readcount;
	private String passwd;
	private int ref;
	private int re_step;
	private int re_level;
	private String ip;
	private Date reg_date;
	private String del;

	// page
	private int startRow;
	private int endRow;
	// 검색
	private String search;
	private String keyword;

}