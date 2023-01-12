package com.account.dto;

import com.account.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDto {
    private String id;
    private TransactionType transactionType=TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;



}
