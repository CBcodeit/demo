package com.techbook.demo.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techbook.demo.model.Product;
import com.techbook.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product){
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }

    public Product findProductById(String id){
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("No such product exists."));
    }


}
