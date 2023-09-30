package com.dipaz.spring.user.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/mi-ruta")
public class UserController {
    @GetMapping("/nueva-ruta")
    public String greetings() {
        return "Hello User!!!";
    }
}
