package springboot_test.securitymember.src.main.java.com.example.demo.service;

import com.example.demo.domain.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

// <CustomUserDetailsService 클래스>
// Spring Security가 DB에서 사용자 정보를 찾을 때 사용하는 서비스 클래스
//1.로그인 시 username 전달
//2.CustomUserDetailsService 호출
//3.DB에서 사용자 조회 (userMapper 사용)
//4.CustomUserDetails로 변환하여 Security에 전달

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    // UserDetails 스프링 시큐리티 프레임워크가 제공하는 인터페이스라서 직접 수정 불가능
    // 대신 구현체(자식 클래스)를 만들어서 메서드를 오버라이드하는 방식으로 활용함 - CustomUserDetails가 자식구현체
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }
}
