package com.dipaz.spring.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/greetings")
    public String greetings() {
        return "Hello World!!!";
    }
}