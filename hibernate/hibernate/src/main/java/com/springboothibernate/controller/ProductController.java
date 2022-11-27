package com.springboothibernate.controller;

import com.springboothibernate.model.Product;
import com.springboothibernate.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(productService.add(product));
    }
}
