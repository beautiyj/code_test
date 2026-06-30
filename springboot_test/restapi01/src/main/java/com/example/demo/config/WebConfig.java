package springboot_test.restapi01.src.main.java.com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// cors 문제 해결용 파일
// 컨트롤러 파일의 @CrossOrigin("*")	// cors 문제 해결용 어노테이션(혹은 config 폴더 방식도 가능. 예시로 2가지 모두 진행)

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//		 	.allowedOrigins("http://localhost:3000")      // react의 3000번 포트 허용
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*").maxAge(3600);
	}
}