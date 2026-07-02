package springboot_test.restapi02.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("board")
public class Board {
	private int no;
	private String writer;
	private String passwd;
	private String subject;
	private String content;
	private int readcount;
	private Date register;
	
}
