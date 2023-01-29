package com.commerce.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String lastName;
    private String middleName;
}
