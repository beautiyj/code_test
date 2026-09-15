package com.myhome.gradletest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 1. http://localhost:8090/ 으로 접속했을 때 index.jsp를 보여주는 주소
    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    // 2. http://localhost:8090/dbtest 로 접속했을 때 dbtest.jsp를 보여주는 주소
    @GetMapping("/dbtest") // ⚠️ 주소창에 .jsp를 빼고 치게끔 깔끔하게 매핑합니다.
    public String dbtest() {
        return "dbtest"; 
    }
}