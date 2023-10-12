package com.dipaz.spring.user.service.user.service.controller;

import com.dipaz.spring.user.service.user.service.model.User;
import com.dipaz.spring.user.service.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
    @RequestMapping(path = "user/res", method = RequestMethod.POST)
    public ResponseEntity<User> addUserResponse(@RequestBody User user){
        User createUser=userRepository.save(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @PostMapping("/tutorials")
    public ResponseEntity<User> createTutorial(@RequestBody User user) {
        try {
            User _user = userRepository.save(new User(user.getFirstname(), user.getLastname(), user.getEmail(),true));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws UserPrincipalNotFoundException {
        try {
            Optional<User> user = userRepository.findById(Long.valueOf(id));
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } catch (Exception e){
            throw new UserPrincipalNotFoundException("User not founf for id: "+id);
        }
    }

}
