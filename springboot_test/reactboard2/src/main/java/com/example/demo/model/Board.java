package springboot_test.reactboard2.src.main.java.com.example.demo.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class Board {
	
	private int no;
	private String writer;
    private String title;
	private String content;
    private Date register;
	
}
