package springboot_test.reactboard3.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("board")
public class Board {
	
	private int no;
	private String writer;
    private String title;
	private String content;
    private Date register;
	
}
