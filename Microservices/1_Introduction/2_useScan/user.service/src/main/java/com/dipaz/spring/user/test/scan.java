package com.dipaz.spring.user.test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class scan {
    @RequestMapping(path = "scan", method = RequestMethod.GET)
    public String scan(){
        return "Hello scan!!!";
    }
}
