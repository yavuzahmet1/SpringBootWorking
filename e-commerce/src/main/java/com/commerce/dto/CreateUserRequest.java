package com.commerce.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String mail;
    private String name;
    private String lastName;
    private String middleName;


}
