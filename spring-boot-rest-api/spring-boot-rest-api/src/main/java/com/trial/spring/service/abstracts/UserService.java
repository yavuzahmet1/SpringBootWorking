package com.trial.spring.service.abstracts;

import com.trial.spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getAll();

    User getUser(Long id);

    User updateUser(Long id, User user);

    Boolean deleteUser(Long id);
}
