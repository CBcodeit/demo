package com.techbook.demo.service;

import com.techbook.demo.model.Category;
import com.techbook.demo.repo.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoriesRepo categoriesRepo;

    @Autowired
    public CategoryService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public Category saveCategory(Category category){
        return categoriesRepo.save(category);
    }

//    public String deleteCategory(String categoryId){
//        Optional<Category> byId = categoriesRepo.findById(categoryId);
//        Category category = byId.orElseThrow(() -> new RuntimeException("No such category"));
//        categoriesRepo.deleteById(categoryId);
//        categoriesRepo.deleteAll();
//        return categoryId;
//    }
}
