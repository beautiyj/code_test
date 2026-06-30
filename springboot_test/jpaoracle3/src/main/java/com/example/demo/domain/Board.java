package springboot_test.jpaoracle3.src.main.java.com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="boards")                         // boards 테이블 생성
@SequenceGenerator(name="boards_seq_gen",     // 시퀀스 제너레이터 이름(이름표 붙이기)
				   sequenceName="boards_seq", // 시퀀스 이름
				   initialValue=1,            // 시작값
				   allocationSize=1 )         // 증가값
public class Board {
	@Id                                     // 기본키 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="boards_seq_gen" )
	// no 필드에 시퀀스 제너레이터@ 연결 // 사용할 전략을 시퀀스로 선택  // 생성기를 boards_seq_gen으로 설정.(이름표 연결하기)
	private int no;
	private String writer;
	private String passwd;
	@Column(length = 500, nullable = false)	 // subject 컬럼에 크기 제한 및 not null 제약조건(name 속성 넣는 것도 가능함)
	private String subject;
	@Column(length = 500, nullable = false)
	private String content;
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;
}