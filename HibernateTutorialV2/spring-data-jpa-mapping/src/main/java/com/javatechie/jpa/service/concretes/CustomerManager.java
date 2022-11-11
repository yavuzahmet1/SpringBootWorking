package com.javatechie.jpa.service.concretes;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRapository;
import com.javatechie.jpa.service.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRapository customerRapository;

    @Override
    public Customer save(Customer customer) {
        return customerRapository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRapository.findAll();
    }

    @Override
    public List<OrderResponse> getJoinInformation() {
        return customerRapository.getJoinInformation();
    }
}
