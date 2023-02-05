package com.commerce;


import com.commerce.dto.UserDto;
import com.commerce.model.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSupport {
    public static List<User> generateUsers() {
        return IntStream.range(0, 5).mapToObj(i ->
                new User((long) i,
                        i + "firstName",
                        "lastName" + i,
                        "firstLast" + i,
                        "@folksdev.net",
                        new Random(2).nextBoolean()
                )).collect(Collectors.toList());
    }

    public static List<UserDto> generateUsers(List<User> userList) {
        return userList.stream()
                .map(from ->
                        new UserDto(
                                from.getId(),
                                from.getName(),
                                from.getLastName(),
                                from.getMiddleName(),
                                from.getEmail()))
                .collect(Collectors.toList());
    }

}
