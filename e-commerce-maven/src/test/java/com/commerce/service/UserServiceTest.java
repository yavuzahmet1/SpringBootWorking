package com.commerce.service;

import com.commerce.TestSupport;
import com.commerce.dto.UserDtoConverter;
import com.commerce.model.User;
import com.commerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class UserServiceTest extends TestSupport {
    private UserDtoConverter converter;
    private UserRepository repository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        converter = Mockito.mock(UserDtoConverter.class);
        repository = Mockito.mock(UserRepository.class);
        userService = new UserService(repository, converter);
    }

    @Test
    public void testGetAllUsers_itShouldReturnUserDtoList() {
        List<User> userList = generateUsers();
        Mockito.when(repository.findAll()).thenReturn(userList);
        Mockito.when(converter.convertList(userList));
    }
}