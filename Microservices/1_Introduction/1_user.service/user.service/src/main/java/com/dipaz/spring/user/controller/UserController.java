package com.dipaz.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @RequestMapping(path = "greetings", method = RequestMethod.GET)
    public String greetings() {
        return "Hello World!!!";
    }
}