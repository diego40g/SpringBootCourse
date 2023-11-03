package com.dipaz.spring.user.service.user.service.controller;

import com.dipaz.spring.user.service.user.service.model.User;
import com.dipaz.spring.user.service.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "user", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user){
        try {
            User createUser = userRepository.save(user);
            HttpHeaders headers = new HttpHeaders();
            headers.add("id", createUser.getId().toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
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

    @RequestMapping(path="user",method=RequestMethod.PUT)
    public ResponseEntity<User>update(@RequestBody User user){
        try {
            User updatedUser=userRepository.save(user);
            return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @RequestMapping(path="user/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        try {
            userRepository.deleteById(Long.valueOf(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
