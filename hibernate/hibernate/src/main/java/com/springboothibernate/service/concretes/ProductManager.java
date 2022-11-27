package com.springboothibernate.service.concretes;

import com.springboothibernate.model.Product;
import com.springboothibernate.respository.ProductDao;
import com.springboothibernate.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Product add(Product product) {
        Product products=new Product();
        products.setId(product.getId());
        products.setName(product.getName());
        products.setStock(product.getStock());
        products.setPrice(product.getPrice());
        products.setDescription(product.getDescription());
        return productDao.save(products);
    }
}
