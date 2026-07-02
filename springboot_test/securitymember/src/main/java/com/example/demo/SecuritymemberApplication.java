package springboot_test.securitymember.src.main.java.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 리액트와 연계해서 실행, 로그인하면 토큰 확인 가능
/* "D:\vs_test\reactworkspace\member" 폴더의 리액트 파일 주소 로컬호스트:9999로 변경, 실행.
 회원가입 후 로그인하면 토큰 발급 스프링부트 콘솔에서 확인 가능(http://localhost:3000)
token:eyJ....
[JWT 필터] 유효한 토큰입니다. username: 1
username: 1
[JWT 필터] 유효한 토큰입니다. username: 1
username: 1
 
 */
@SpringBootApplication
public class SecuritymemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritymemberApplication.class, args);
	}

}
