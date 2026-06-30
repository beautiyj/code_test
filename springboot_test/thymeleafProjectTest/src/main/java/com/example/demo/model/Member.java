package springboot_test.thymeleafProjectTest.src.main.java.com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor		// 모든 매개변수가 있는 생성자를 만들어줌
@Data
public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
}

/*
 @AllArgsConstructor 어노테이션이
 public Member(int no, String id, String pw, String name, Timestamp regdate) {
	this.no = no;
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.regdate = regdate;
}
	생성자 코드를 만들어주는 어노테이션(해당 코드를 생략해도 됨) 
 */
 