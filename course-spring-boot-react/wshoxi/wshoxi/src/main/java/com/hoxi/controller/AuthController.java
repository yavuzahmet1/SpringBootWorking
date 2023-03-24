package com.hoxi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/api/1.0/auth")
    void handleAuthentication(@RequestHeader(name = "Authorization",required = false) String authorization) {
        log.info(authorization);
    }
}
