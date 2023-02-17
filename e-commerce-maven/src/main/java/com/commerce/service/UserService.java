package com.commerce.service;

import com.commerce.dto.CreateUserRequest;
import com.commerce.dto.UpdateUserRequest;
import com.commerce.dto.UserDto;
import com.commerce.dto.UserDtoConverter;
import com.commerce.exception.UserIsNotActiveException;
import com.commerce.exception.UserNotFoundException;
import com.commerce.model.User;
import com.commerce.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userDtoConverter.convertList(userRepository.findAll());
    }

    public UserDto getByUserId(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = new User(
                null,
                createUserRequest.getName(),
                createUserRequest.getLastName(),
                createUserRequest.getMiddleName(),
                createUserRequest.getEmail(), true, null);
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        if (!user.getIsActive()) {
            logger.warn(String.format("The user wanted update is not active!"));
            throw new UserIsNotActiveException();
        }
        User updateUser = new User(
                user.getId(),
                updateUserRequest.getName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName(),
                user.getEmail(), true, user.getUserDetailsSet());
        return userDtoConverter.convert(userRepository.save(updateUser));
    }

    public void deleteUser(Long id) {
        if (doesUserExist(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User couldn't be found by following id :" + id);
        }
    }

    protected User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User couldn't be found by following id : " + id));
    }

    public void deactivateUser(Long id) {
        changeActivateUser(id, false);
    }

    public void activeUser(Long id) {
        changeActivateUser(id, true);
    }

    private void changeActivateUser(Long id, Boolean isActive) {
        User user = findUserById(id);
        User updateUser = new User(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getEmail(), isActive, user.getUserDetailsSet());
        userRepository.save(updateUser);
    }

    private boolean doesUserExist(Long id) {
        return userRepository.existsById(id);
    }

    /*private User findUserByMail(String mail) {
        return userRepository.findByMail(mail)
                .orElseThrow(
                        () -> new UserNotFoundException("User couldn't be found by following id : " + mail));
    }*/
}
