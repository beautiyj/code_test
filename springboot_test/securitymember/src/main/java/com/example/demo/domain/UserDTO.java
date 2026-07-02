package springboot_test.securitymember.src.main.java.com.example.demo.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("user")
public class UserDTO {
    private Long id;           // 사용자 고유 ID
    private String username;   // 로그인 ID
    private String password;   // 비밀번호
    private String name;       // 이름
    private String email;      // 이메일
    private String role;       // 권한 (USER, ADMIN)
    private Date reg_date;	   // 가입일
}
