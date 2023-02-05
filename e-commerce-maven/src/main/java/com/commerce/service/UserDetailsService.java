package com.commerce.service;

import com.commerce.dto.CreateUserDetailsRequest;
import com.commerce.dto.UserDetailsDto;
import com.commerce.dto.UserDetailsDtoConverter;
import com.commerce.model.User;
import com.commerce.model.UserDetails;
import com.commerce.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    private final UserService userService;
    private final UserDetailsDtoConverter converter;


    public UserDetailsService(UserDetailsRepository userDetailsRepository, UserService userService, UserDetailsDtoConverter converter) {
        this.userDetailsRepository = userDetailsRepository;
        this.userService = userService;
        this.converter = converter;

    }

    public UserDetailsDto createUser(final CreateUserDetailsRequest request) {
        User user = userService.findUserById(request.getUserId());

        UserDetails userDetails = new UserDetails(
                request.getPhoneNumber(),
                request.getAddress(),
                request.getCity(),
                request.getCountry(),
                request.getPostCode(),
                user);

        return converter.convert(userDetailsRepository.save(userDetails));
    }

} //hata var kaldığım video dakikası 37. dakika bakılacak
