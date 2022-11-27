package com.springboothibernate.service.abstracts;

import com.springboothibernate.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product add(Product product);
}
