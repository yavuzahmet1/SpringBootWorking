package com.javatechie.jpa.service.abstracts;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> findAll();

    List<OrderResponse> getJoinInformation();
}
