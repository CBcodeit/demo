package com.techbook.demo;

import com.techbook.demo.model.Category;
import com.techbook.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryStarter implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;
    @Override
    public void run(String... args) throws Exception {
        categoryService.saveCategory(new Category("Kitchen Furniture"));
        categoryService.deleteCategory("675df4604e64b564c4951b50");
    }
}
