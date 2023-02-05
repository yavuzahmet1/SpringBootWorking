package com.commerce.dto;

import lombok.Data;

@Data
public class CreateUserDetailsRequest {
    private Long userId;
    private String phoneNumber;
    private String address;
    private String country;
    private String postCode;

}
