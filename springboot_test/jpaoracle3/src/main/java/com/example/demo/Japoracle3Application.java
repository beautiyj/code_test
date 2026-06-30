package springboot_test.jpaoracle3.src.main.java.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// netstat -ano | findstr :9999
// taskkill /f /pid 사용중인번호

@SpringBootApplication
public class Japoracle3Application {

	public static void main(String[] args) {
		SpringApplication.run(Japoracle3Application.class, args);
	}

}
