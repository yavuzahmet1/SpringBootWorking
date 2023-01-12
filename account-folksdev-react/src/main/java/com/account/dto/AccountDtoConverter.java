package com.account.dto;

import com.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountDtoConverter {
    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDto convert(Account from) {
        return new AccountDto(from.getId(), from.getBalance(), from.getCreationDate(), customerDtoConverter.convertToAccountCustomer(from.getCustomer()), from.getTransaction()
                .stream()
                .map(transactionDtoConverter::convert)
                .collect(Collectors.toSet()));
    }
}
