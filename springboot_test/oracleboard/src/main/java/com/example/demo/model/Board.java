package springboot_test.oracleboard.src.main.java.com.example.demo.model;

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
}

/*
 * 스프링부트 실습용 테이블 create table myboard2( no number primary key, writer
 * varchar2(20), passwd varchar2(20), subject varchar2(50), content
 * varchar2(100), readcount number, register date );
 * 
 * create sequence myboard2_seq start with 1 increment by 1 nocache;
 * 
 * 
 */