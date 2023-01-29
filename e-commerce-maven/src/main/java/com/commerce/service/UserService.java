package com.commerce.service;

import com.commerce.dto.CreateUserRequest;
import com.commerce.dto.UpdateUserRequest;
import com.commerce.dto.UserDto;
import com.commerce.dto.UserDtoConverter;
import com.commerce.exception.UserNotFoundException;
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
         List<UserDto> users=userRepository.findAll().
               stream()
                //.map(convert->userDtoConverter.convert(convert))
                .map(userDtoConverter::convert)
                .collect(Collectors.toList());
        return users;
    }

    public UserDto getByUserId(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = new User(null,
                createUserRequest.getName(),
                createUserRequest.getLastName(),
                createUserRequest.getMiddleName(),
                createUserRequest.getEmail());
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        User updateUser = new User(user.getId(),
                updateUserRequest.getName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName(),
                user.getEmail());
        return userDtoConverter.convert(userRepository.save(updateUser));
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        /*User user = findUserById(id);
        userRepository.delete(user);*/
    }
    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User couldn't be found by following id : " + id));
    }
    /*private User findUserByMail(String mail) {
        return userRepository.findByMail(mail)
                .orElseThrow(
                        () -> new UserNotFoundException("User couldn't be found by following id : " + mail));
    }*/
}