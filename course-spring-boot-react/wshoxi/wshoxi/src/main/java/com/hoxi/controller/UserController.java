package com.hoxi.controller;

import com.hoxi.entity.User;
import com.hoxi.error.ApiError;
import com.hoxi.service.UserService;
import com.hoxi.shered.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> createUser(@RequestBody User user) {

        String userName = user.getUserName();

        if (userName == null || userName.isEmpty()) {

            ApiError error = new ApiError(400, "Validation Error", "/api/1.0/users");

            Map<String, String> validationsErrors = new HashMap<>();
            validationsErrors.put("userName", "user name can not be null");
            error.setValidationsErrors(validationsErrors);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        log.info(user.toString());
        userService.saveUser(user);
        GenericResponse generic = new GenericResponse("User created!");
        //generic.setMessage("User created!");
        //return generic;
        return ResponseEntity.ok(new GenericResponse("user created"));


    }
}
