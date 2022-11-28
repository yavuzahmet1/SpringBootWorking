package com.example.yvzbytes.tutorial.repository;

import com.example.yvzbytes.tutorial.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
