package springboot_test.jpaoracle2.src.main.java.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// netstat -ano | findstr :9999
// taskkill /f /pid 사용중인번호

@SpringBootApplication
public class Japoracle2Application {

	public static void main(String[] args) {
		SpringApplication.run(Japoracle2Application.class, args);
	}

}
