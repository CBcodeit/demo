package com.techbook.demo;

import com.techbook.demo.model.Product;
import com.techbook.demo.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final ProductService productService;

    public StartupRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
       productService.saveProduct(new Product("Dinning Chair", "this is four legs wooden chair", 1000d));

    }
}

