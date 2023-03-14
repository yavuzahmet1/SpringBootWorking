package com.hoxi.controller;

import com.hoxi.entity.User;
import com.hoxi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;



    @CrossOrigin
    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User user){
        log.info(user.toString());
        userRepository.save(user);


    }
}
