package com.trial.spring.service.abstracts;

import com.trial.spring.dto.UserDto;
import com.trial.spring.entity.User;
import com.trial.spring.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    Boolean deleteUser(Long id);
    Page<User> pagination(int currentPage,int pageSize);
    Page<User> pagination(Pageable pageable);

    Slice<User> slice(Pageable pageable);

    CustomPage<UserDto> customPagination(Pageable pageable);
}
