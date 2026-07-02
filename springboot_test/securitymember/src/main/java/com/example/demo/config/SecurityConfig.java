package springboot_test.securitymember.src.main.java.com.example.demo.config;

import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 보안 설정 + 필터 설정 + JWT 허용 경로 설정
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtTokenProvider jwtTokenProvider;
	private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    // Spring Security의 필터 체인 설정 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // CORS 설정 활성화 (WebConfig에서 설정한 CORS 정책을 따름)
//          .cors(cors -> cors.disable()) // 개발 중엔 disable, 운영 시 필요하면 enable

            // CSRF 보호 기능 비활성화 (JWT 기반 API에서는 보통 사용하지 않음)
            .csrf(csrf -> csrf.disable())

            // 세션을 사용하지 않도록 설정 (STATELESS → 매 요청마다 JWT 인증)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 요청에 대한 권한 설정
            .authorizeHttpRequests(auth -> auth
                // 인증 없이 접근 가능한 경로 설정
                .requestMatchers(
                    "/api/main",       // 메인화면 
                    "/api/login",      // 로그인 API
                    "/api/register",   // 회원가입 API
                    "/api/profile",    // 마이페이지
                    "/static/**",      // 정적 리소스
                    "/css/**", "/js/**", "/images/**"                  
                ).permitAll()

                // 그 외의 요청은 인증 필요
                .anyRequest().authenticated()
            )

            // JwtAuthenticationFilter를 직접 생성해서 등록
            // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 등록    
            .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService), 
            		UsernamePasswordAuthenticationFilter.class)
            
            // 빌더 종료
            .build();
    }

  
    // AuthenticationManager Bean 등록
    // Spring Security 내부에서 로그인 인증 처리 시 사용됨
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
