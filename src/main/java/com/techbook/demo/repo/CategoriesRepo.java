package com.techbook.demo.repo;

import com.techbook.demo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends MongoRepository<Category,String> {
}
