package com.commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsDto {
    private String phoneNumber;
    private String address;
    private String country;
    private String postCode;

}
