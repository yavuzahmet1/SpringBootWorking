package com.account.dto;

import com.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final CustomerAccountDtoConvertor convertor;

    public CustomerDtoConverter(CustomerAccountDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getLastName());
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(from.getId()
                , from.getName()
                , from.getLastName()
                ,from.getAccounts()
                .stream()
                .map(convertor::convert)
                .collect(Collectors.toSet()));
    }

}
