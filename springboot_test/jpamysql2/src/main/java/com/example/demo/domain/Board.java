package springboot_test.jpamysql2.src.main.java.com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "boards")			// boards 테이블 생성
public class Board {
	@Id							// 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 속성: 번호 자동 증가(오라클의 시퀀스같은)
	private int no;
	private String writer;
	private String passwd;
	private String subject;
	private String content;
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;
}