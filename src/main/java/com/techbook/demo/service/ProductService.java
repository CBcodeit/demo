package com.techbook.demo.service;

import com.techbook.demo.model.Product;
import com.techbook.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product){
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }
}
