package springboot_test.securitymember.src.main.java.com.example.demo.service;

import com.example.demo.domain.UserDTO;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    
     // 회원 가입    
    public int signup(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 암호화
        user.setRole("USER"); // 기본 권한
        return userMapper.insertUser(user);
    }

    // 사용자 ID로 조회
    public UserDTO findById(Long id) {
        return userMapper.findById(id);
    }

    // 사용자명으로 조회 (로그인용)
    public UserDTO findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    
}

