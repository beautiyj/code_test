package springboot_test.securitymember.src.main.java.com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


// CORS + 정적 리소스 + ViewResolver 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // CORS(Cross-Origin Resource Sharing) 설정
    // React(3000 포트)에서 오는 요청 허용
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                       // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000") // React 개발 서버 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용 메서드
                .allowedHeaders("*")                     // 모든 헤더 허용
                .allowCredentials(true);                 // 인증정보 포함 허용 (쿠키 등)
    }

   
    // 정적 자원 (CSS, JS, 이미지 등)의 경로 설정
    // 예: /static/js/main.js → /resources/static/js/main.js 에서 제공됨
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**") // URL 경로
//                .addResourceLocations("classpath:/static/"); // 실제 리소스 위치
//    }

  
    // ViewResolver 설정
    // /WEB-INF/views/ 폴더 아래 JSP 파일들을 View로 사용함
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/", ".jsp");
//    }
}
