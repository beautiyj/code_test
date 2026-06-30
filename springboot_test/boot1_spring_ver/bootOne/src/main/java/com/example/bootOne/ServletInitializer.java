package springboot_test.boot1_spring_ver.bootOne.src.main.java.com.example.bootOne;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 그래들로 진행하면 ServletInitializer 파일은 없어도 됨
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootOneApplication.class);
	}

}
