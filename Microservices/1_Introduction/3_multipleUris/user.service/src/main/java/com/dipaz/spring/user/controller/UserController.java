package com.dipaz.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(path = {"saludo","hello"}, method = RequestMethod.GET)
    public String saludo(){
        return "Hola controller XD!!!";
    }
}
