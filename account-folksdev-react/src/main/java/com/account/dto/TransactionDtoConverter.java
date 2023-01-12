package com.account.dto;

import com.account.model.Transaction;

public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(),from.getTransactionType(),from.getAmount(),from.getTransactionDate());
    }
}
