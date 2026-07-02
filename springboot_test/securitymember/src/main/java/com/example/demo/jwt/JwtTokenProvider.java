package springboot_test.securitymember.src.main.java.com.example.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

// <JwtTokenProvider 클래스>
// JWT(Json Web Token)를 생성(createToken) 하고, 
// 토큰에서 사용자명 추출(getUsername) 및 토큰 검증(validateToken) 을 담당하는 컴포넌트이다.
//1. @Value로 설정값(시크릿 키, 만료시간)을 주입받아 JWT를 서명하고 검증한다.
//2. JWT 생성 시 사용자명(subject)과 추가 클레임(role)을 포함한다.
//3. 검증 시 토큰이 정상 서명되었는지, 만료되었는지 등을 검사하여 true/false 반환한다.

@Component
public class JwtTokenProvider {

	// 서명에 사용할 비밀 키(application.properties에서 주입)
	// 시크릿 길이와 형식
    // HS256을 안전하게 사용하려면 비밀키가 충분히 길고 랜덤해야 합니다(권장: 최소 256비트(32바이트) 이상)
    @Value("${jwt.secret}")
    private String secretKey;

    // 토큰 만료 기간 (밀리초 단위)
    // 3600000 -> 1시간
    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    // 토큰 생성
    // 1. Claims 생성 및 사용자명(subject) 설정
    // 2. role 같은 추가 클레임을 집어넣음
    // 3. 현재 시간으로 발급시간 설정, 만료시간 계산
    // 4. HMAC-SHA256 알고리즘으로 비밀키를 이용해 서명 후 compact()함수로 문자열(token) 반환
    public String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)				// payload에 claims 설정
                .setIssuedAt(now)			    // 토큰 발급 시간
                .setExpiration(validity)		// 토큰 만료 시간	
                // 서명 : 비밀값과 함께 해시값을 HS256 알고리즘으로 암호화
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰에서 사용자명 추출
    // 1. 토큰을 파싱(parseClaimsJws)하여 검증 후 claim body에서 사용자명(subject)을 반환
    // 2. 토큰이 유효하지 않으면 예외가 발생할 수 있음
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();                        // 사용자명(subject) 반환
    }

    // 토큰 유효성 검사
    // 1. parser로 토큰을 파싱하여 서명 검증/만료 검사 수행
    // 2. 예외 발생시 false 반환
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())   // 비밀키로 복호화
                .build()
                .parseClaimsJws(token);  	           // 토큰 파싱 및 검증	   
            return true;                               // 유효한 token이면 true 반환
            
        // 토큰이 만료되었거나 변조된 경우 예외 발생    
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
