package com.javatechie.jpa.repository;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRapository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.javatechie.jpa.dto.OrderResponse (c.name, p.ProductName) from Customer c join c.products p")
    public List<OrderResponse> getJoinInformation();
}
