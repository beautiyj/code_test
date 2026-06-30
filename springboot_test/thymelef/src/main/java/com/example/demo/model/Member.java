package springboot_test.thymelef.src.main.java.com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor    // 모든 매개변수가 있는 생성자를 만들어 주는 어노테이션
@Data                  // getter, setter 메소드 만들어 주는 어노테이션
public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
	
//	public Member(int no, String id, String pw, String name, Timestamp regdate) {
//		this.no = no;
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.regdate = regdate;
//	}
	
	
}
