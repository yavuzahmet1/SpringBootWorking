package com.commerce.dto;

import com.commerce.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getMail(),
                from.getName(),
                from.getLastName(),
                from.getMiddleName());
    }
}
