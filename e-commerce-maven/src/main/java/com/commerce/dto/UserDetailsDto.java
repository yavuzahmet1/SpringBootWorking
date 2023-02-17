package com.commerce.dto;

import com.commerce.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsDto {
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postCode;
    private User user;

}