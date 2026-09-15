package com.myhome.gradletest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 👈 뒤에 있던 괄호(exclude = ...)를 싹 지우고 이렇게만 남겨주세요!
public class GradletestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradletestApplication.class, args);
    }

}