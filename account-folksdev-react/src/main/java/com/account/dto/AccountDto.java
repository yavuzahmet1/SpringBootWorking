package com.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class AccountDto {
    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto customer;
    private Set<TransactionDto> transactions;
}
