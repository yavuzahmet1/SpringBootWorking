package com.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String lastName;
    private Set<CustomerAccountDto> accounts;

}
