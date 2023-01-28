package com.commerce.service;

import com.commerce.dto.CreateUserRequest;
import com.commerce.dto.UserDto;
import com.commerce.dto.UserDtoConverter;
import com.commerce.model.User;
import com.commerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User couldn't be found by following id : " + id));
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user=new User(userRequest.getMail(),userRequest.getName(),userRequest.getLastName(),userRequest.getMiddleName());
    }///58.00 dakikada kaldım
}
