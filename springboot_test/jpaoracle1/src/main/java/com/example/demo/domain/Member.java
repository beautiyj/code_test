package springboot_test.jpaoracle1.src.main.java.com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

/*  Entity 클래스의 어노테이션

	@NoArgsConstructor 		         : 파라미터가 없는 기본 생성자를 만들어준다.
	@AllArgsConstructor     	     : 모든 필드를 파라미터로 가진 생성자만 만들어준다.
	@Setter                          : setter 메소드 생성
	@Getter                          : getter 메소드 생성
	@Data                            : getter, setter 메소드 생성
	@Entity                          : 해당 클래스를 Entity 클래스로 설정
	@Table(name="members") 			 : members 테이블 생성
	@Id                              :  기본키 설정
	
	@GeneratedValue(strategy = GenerationType.AUTO)  : JPA구현체(Hibernate)가 자동으로 생성 방식을 결정
	                                                   hibernate_sequence가 자동으로 생성된다.
	@Column(length = 500, nullable = false)          : 크기 500Byte, not null제약조건
 
 */
@Data                           // getter, setter 메소드 생성
@Entity							// 현재 클래스를 엔티티 클래스로 지정
@Table(name="members")          // 테이블 이름 설정
public class Member {
	
	@Id							// 기본키 제약조건 설정
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	@CreationTimestamp			// 회원가입 시간
	private Timestamp regdate;
	
	@UpdateTimestamp            // 회원수정 시간
	private Timestamp updatedate;
	
}


/*
 spring.jpa.hibernate.ddl-auto=update
 이 옵션이 JPA(정확히는 구현체인 Hibernate)가 @Entity 클래스를 분석해서
 거기에 맞는 CREATE TABLE 같은 DDL(테이블 생성 쿼리)을 자동으로 만들어주고 실행하는 역할
 
 @Table(name="members")          // 테이블 이름 설정
	각 제약 조건 등등에 맞게 알아서 테이블 생성
	
  */
 