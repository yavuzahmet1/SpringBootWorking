package com.javatechie.jpa.service.concretes;

import com.javatechie.jpa.repository.ProductRepository;
import com.javatechie.jpa.service.abstracts.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
}
