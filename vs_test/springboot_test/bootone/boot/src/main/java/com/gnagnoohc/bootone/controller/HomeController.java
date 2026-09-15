package com.gnagnoohc.bootone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome to spring boot<br>"
             + "스프링부트 홈컨트롤러 코드";
    }
}