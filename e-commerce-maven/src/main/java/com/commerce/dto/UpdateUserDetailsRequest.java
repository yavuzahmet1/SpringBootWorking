package com.commerce.dto;

import lombok.Data;

@Data
public class UpdateUserDetailsRequest {
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postCode;
}
