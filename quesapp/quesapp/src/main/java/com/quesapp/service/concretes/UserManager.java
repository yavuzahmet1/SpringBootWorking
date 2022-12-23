package com.quesapp.service.concretes;

import com.quesapp.entities.User;
import com.quesapp.repository.UserRepository;
import com.quesapp.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User newUser) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
