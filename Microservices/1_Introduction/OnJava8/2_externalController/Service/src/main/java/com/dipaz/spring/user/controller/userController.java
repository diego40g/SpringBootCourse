package com.dipaz.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @RequestMapping(path = "saludo", method = RequestMethod.GET)
    public String saludo(){
        return "Hola mundo controller!!!";
    }
}
