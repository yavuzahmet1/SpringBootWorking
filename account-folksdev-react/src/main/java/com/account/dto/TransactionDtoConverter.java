package com.account.dto;

import com.account.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId()
                ,from.getTransactionType()
                ,from.getAmount()
                ,from.getTransactionDate());
    }
}
