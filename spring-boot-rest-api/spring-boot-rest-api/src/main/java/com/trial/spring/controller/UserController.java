package com.trial.spring.controller;

import com.trial.spring.entity.User;
import com.trial.spring.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // User resultUser=userService.createUser(user);
        // return ResponseEntity.ok(resultUser);
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id, User user) {
        User resultUser = userService.getUser(id);
        return ResponseEntity.ok(resultUser);
    }
    @PutMapping("{id}")
    public ResponseEntity<User>updateUser(@PathVariable Long id, @RequestBody User user){
        //User resultUser=userService.updateUser(id,user);
       // return ResponseEntity.ok(resultUser);
        return ResponseEntity.ok(userService.updateUser(id,user));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
/*ResponseEntity<User>Böylelikjle metodlarımıza ortak imza yeteneği kazandırmış oluyoruz.
 * @RequestBody->JSON nesnemizi User claslarımızla eşleşitirmyei sağlıuoruz
 * @RequestBody->gelen nesnenin işlenmesini sağlıyoruz
 * */