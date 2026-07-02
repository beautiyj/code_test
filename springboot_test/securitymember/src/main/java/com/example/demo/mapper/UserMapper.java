package springboot_test.securitymember.src.main.java.com.example.demo.mapper;

import com.example.demo.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 사용자 등록
    int insertUser(UserDTO user);

    // 사용자 조회 (username 기준, 로그인용)
    UserDTO findByUsername(String username);

    // ID로 사용자 조회
    UserDTO findById(Long id);
}

