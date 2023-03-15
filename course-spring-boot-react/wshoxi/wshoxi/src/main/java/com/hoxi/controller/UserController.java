package com.hoxi.controller;

import com.hoxi.entity.User;
import com.hoxi.service.UserService;
import com.hoxi.shered.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin
    @PostMapping("/api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@RequestBody User user) {
        log.info(user.toString());
        userService.saveUser(user);
        GenericResponse generic = new GenericResponse("User created!");
        //generic.setMessage("User created!");
        return generic;


    }
}
