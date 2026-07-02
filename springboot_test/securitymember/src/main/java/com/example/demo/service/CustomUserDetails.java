package springboot_test.securitymember.src.main.java.com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// <CustomUserDetails 클래스>: 자식 구현체(인터페이스 UserDetails를 상속받은 인터페이스 구현체임)
// Spring Security에서 사용하는 UserDetails 상속 받는 구현 클래스
// JWT로 인증된 사용자 정보를 담는 클래스

@Getter
@Setter
@AllArgsConstructor         // 모든 필드를 매개변수로 받는 생성자    
@NoArgsConstructor		    // 기본 생성자  
public class CustomUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role); // 간단히 처리
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}