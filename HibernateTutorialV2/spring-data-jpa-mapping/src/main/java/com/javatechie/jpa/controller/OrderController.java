package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRapository;
import com.javatechie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRapository customerRapository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeorder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRapository.save(request.getCustomer());
    }

    @GetMapping("/findallorders")
    public List<Customer> findAllOrders(){
        return customerRapository.findAll();

    }
    @GetMapping("/getinfo")
    public List<OrderResponse> getJoinInformat(){
        return customerRapository.getJoinInformation();
    }
}
