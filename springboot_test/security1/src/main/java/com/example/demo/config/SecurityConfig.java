package springboot_test.security1.src.main.java.com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 @Bean: 스프링 부트에게 SecurityFilterChain이라는 객체를 생성해서 관리하라고 알려주는 것입니다.
 		이 객체가 바로 우리가 앞서 말한 '경비원'의 세부 규칙을 담고 있습니다.
 
 유연성: 이렇게 Config 클래스로 분리해두면 나중에 보안 규칙을 바꾸고 싶을 때
  	   Controller나 다른 코드를 건드릴 필요 없이 오직 이 파일만 수정하면 됩니다.
 
 현재 이 파일이 있든 없든 시큐리티는 작동하고 있음
 일반적으로 콘피그 파일 만들어둬서 예시로 코드 추가해둠
 */
@Configuration // 1. 설정 파일임을 명시
@EnableWebSecurity // 2. 스프링 시큐리티 활성화
public class SecurityConfig {

    @Bean // 3. 이 메서드가 반환하는 객체를 스프링이 관리하게 함
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 테스트를 위해 CSRF 방어 잠시 끔
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // 우선 모든 요청을 허용 (나중에 수정 가능)
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/member/list", true) // 로그인 성공 시 이동 경로
                .permitAll()
            );
            
        return http.build();
    }
}