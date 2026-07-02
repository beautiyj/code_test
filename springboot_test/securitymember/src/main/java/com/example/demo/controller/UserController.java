package springboot_test.securitymember.src.main.java.com.example.demo.controller;

import com.example.demo.domain.UserDTO;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.service.CustomUserDetails;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

// PS D:\vs_test\reactworkspace\ajaxtest01> 랑 연계


@RestController
//@CrossOrigin("*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 API
    @PostMapping("/register")
    public ResponseEntity<String> signup(@RequestBody UserDTO user) {
        int result = userService.signup(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인 API - JWT 발급
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        // 인증 시도
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        // 인증 성공 시 JWT 발급
        String token = jwtTokenProvider.createToken(authentication.getName(), "USER");
        
        System.out.println("token:"+ token);
        
        return ResponseEntity.ok().body(new TokenResponse(token)); // 토큰을 JSON 형태로 반환(key가 있는 형태)
//		return ResponseEntity.ok(token);                           // token 문자열만 반환(key가 없는 형태)   
    }
    
    // 마이페이지 API - 인증된 사용자 정보 반환
    @GetMapping("/profile")
    public UserDTO getProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        System.out.println("username: " + userDetails.getUsername());
        if (userDetails == null) {
            throw new RuntimeException("인증된 사용자 정보를 찾을 수 없습니다."); 
        }
        
        return userService.findByUsername(userDetails.getUsername());
    }
    

    // 내부 응답 DTO (Token 반환용)
    record TokenResponse(String token) {}  
    
}

