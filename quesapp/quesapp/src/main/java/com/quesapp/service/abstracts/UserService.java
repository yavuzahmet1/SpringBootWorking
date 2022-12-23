package com.quesapp.service.abstracts;

import com.quesapp.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User saveUser(User newUser);

    User getOneUserById(Long id);

    User updateUser(Long id, User newUser);

    void deleteById(Long id);
}
