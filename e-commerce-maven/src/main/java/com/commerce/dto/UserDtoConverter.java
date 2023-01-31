package com.commerce.dto;

import com.commerce.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    public UserDto convert(User from) {
        return new UserDto(from.getId(),
                from.getName(),
                from.getLastName(),
                from.getMiddleName(),
                from.getEmail());
    }

    public List<UserDto> convertList(List<User> fromList) {
        return fromList.stream()
                .map(from -> new UserDto(from.getId(),
                        from.getName(),
                        from.getLastName(),
                        from.getMiddleName(),
                        from.getEmail()))
                .collect(Collectors.toList());
    }
}
