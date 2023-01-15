package com.account.dto;

import com.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConvertor {
    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConvertor(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(from.getId()
                , from.getBalance()
                , from.getTransaction()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toSet())
                , from.getCreationDate());
    }
}
