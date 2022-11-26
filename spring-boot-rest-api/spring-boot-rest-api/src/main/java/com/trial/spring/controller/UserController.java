package com.trial.spring.controller;

import com.trial.spring.dto.UserDto;
import com.trial.spring.entity.User;
import com.trial.spring.service.abstracts.UserService;
import com.trial.spring.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        // User resultUser=userService.createUser(user);
        // return ResponseEntity.ok(resultUser);
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id, UserDto userDto) {
        UserDto resultUser = userService.getUser(id);
        return ResponseEntity.ok(resultUser);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        //User resultUser=userService.updateUser(id,user);
        // return ResponseEntity.ok(resultUser);
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> pagination(@RequestParam int currentPage,@RequestParam int pageSize) {
        return ResponseEntity.ok(userService.pagination(currentPage,pageSize));
    }
    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>> pagination(Pageable pageable) {
        return ResponseEntity.ok(userService.pagination(pageable));
    }
    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>> slice(Pageable pageable) {
        return ResponseEntity.ok(userService.slice(pageable));
    }
    @GetMapping("/pagination/v3")
    public ResponseEntity<CustomPage<UserDto>> customPagination(Pageable pageable) {
        return ResponseEntity.ok(userService.customPagination(pageable));
    }
}
/*ResponseEntity<User>Böylelikjle metodlarımıza ortak imza yeteneği kazandırmış oluyoruz.
 * @RequestBody->JSON nesnemizi User claslarımızla eşleşitirmyei sağlıuoruz
 * @RequestBody->gelen nesnenin işlenmesini sağlıyoruz
 * */