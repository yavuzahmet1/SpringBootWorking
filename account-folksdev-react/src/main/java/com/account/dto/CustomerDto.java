package com.account.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CustomerDto {
    private String id;
    private String name;
    private String lastName;
    private Set<CustomerAccountDto> accounts;

}
