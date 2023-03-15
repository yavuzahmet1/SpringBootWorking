package com.hoxi.service;

import com.hoxi.entity.User;
import com.hoxi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;//passworları encode eder

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void saveUser(User user) {
        /*String encryptedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);*/ //veya aşağıdaki gibi kısacada yazılabilir.

        user.setPassword(this.passwordEncoder.encode(user.getPassword())); //password encode oldu

        userRepository.save(user);

    }
}
