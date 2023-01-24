package com.commerce.service;

import com.commerce.dto.UserDto;
import com.commerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserDto> getAllUser(){
        return userRepository.findAll();
    }
}
