package com.quesapp.controller;

import com.quesapp.entities.User;
import com.quesapp.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getOneUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
