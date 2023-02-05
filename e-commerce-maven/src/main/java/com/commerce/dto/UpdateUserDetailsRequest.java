package com.commerce.dto;

import lombok.Data;

@Data
public class UpdateUserDetailsRequest {
    private String phoneNumber;
    private String address;
    private String country;
    private String postCode;
}
