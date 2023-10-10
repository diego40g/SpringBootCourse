package com.dipaz.spring.user.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dipaz.spring.user.service.model.User;
import com.dipaz.spring.user.service.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String firstname) {
        try {
            List<User> users = new ArrayList<User>();
            if(firstname==null){
                userRepository.findAll().forEach(users::add);
            }else{
                userRepository.findByFirstnameContainingIgnoreCase(firstname).forEach(users::add);
            }

            if(users.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User _user = userRepository.save(new User(user.getFirstname(), user.getLastname(), user.getAge()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
