package springboot_test.board2.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("rb")
public class ReplyBoard {
	
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	
}