package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRapository;
import com.javatechie.jpa.repository.ProductRepository;
import com.javatechie.jpa.service.abstracts.CustomerService;
import com.javatechie.jpa.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @PostMapping("/placeorder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerService.save(request.getCustomer());
    }

    @GetMapping("/findallorders")
    public List<Customer> findAllOrders(){
        return customerService.findAll();

    }
    @GetMapping("/getinfo")
    public List<OrderResponse> getJoinInformat(){

        return customerService.getJoinInformation();
    }
}
