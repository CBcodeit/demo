package com.techbook.demo.repo;

import com.techbook.demo.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CategoriesRepoTest {
    @Autowired
    private CategoriesRepo categoriesRepo;

    @Test
    public void testSaveCategoryReturnSavedCategory(){
        //Arrange
        //Category categoryWithParent = new Category("Bed","Bed Category");
        Category categoryWithParent = Category.builder().name("Bed").parentCategory("Bed Category").build();
        //Act
        Category savedCategoryWithParent = categoriesRepo.save(categoryWithParent);
        //Assert
        Assertions.assertThat(savedCategoryWithParent).isNotNull();
        Assertions.assertThat(savedCategoryWithParent.getId()).isNotNull();
        Assertions.assertThat(savedCategoryWithParent.getName()).isEqualTo("Bed");
        Assertions.assertThat(savedCategoryWithParent.getParentCategory()).isEqualTo("Bed Category");
    }

    @Test
    public void testFindAllCategoriesReturnMoreThanOneCategories(){
        //Arrange
        Category categoryWithParent1 = Category.builder().name("Bed").parentCategory("Bed Category").build();
        Category categoryWithParent2 = Category.builder().name("Pillow").parentCategory("Bed Category").build();


        categoriesRepo.deleteAll();
        categoriesRepo.save(categoryWithParent1);
        categoriesRepo.save(categoryWithParent2);
        //Act
        List<Category> all = categoriesRepo.findAll();
        //Assert
        Assertions.assertThat(all).isNotNull();
        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all.get(0).getId()).isNotNull();
        Assertions.assertThat(all.get(0).getName()).isEqualTo("Bed");
        Assertions.assertThat(all.get(0).getParentCategory()).isEqualTo("Bed Category");
        Assertions.assertThat(all.get(1).getName()).isEqualTo("Pillow");
        Assertions.assertThat(all.get(1).getParentCategory()).isEqualTo("Bed Category");

    }

    @Test
    public void testFindAllCategoriesReturnZeroCategories(){
        //Arrange
        categoriesRepo.deleteAll();

        //Act
        List<Category> all = categoriesRepo.findAll();
        //Assert
        Assertions.assertThat(all).isNotNull();
        Assertions.assertThat(all).hasSize(0);

    }



    @Test
    public void testFindCategoryByIdReturnOneCategory(){
        //Arrange
        categoriesRepo.deleteAll();
        Category categoryWithParent = Category.builder().name("Bed").parentCategory("Bed Category").build();
        Category savedCategory = categoriesRepo.save(categoryWithParent);
        //Act
        Optional<Category> categoryFound = categoriesRepo.findById(savedCategory.getId());
        //Assert
        Assertions.assertThat(categoryFound.isPresent()).isTrue();
        Assertions.assertThat(categoryFound.get().getId()).isNotNull();
        Assertions.assertThat(categoryFound.get().getName()).isEqualTo("Bed");
        Assertions.assertThat(categoryFound.get().getParentCategory()).isEqualTo("Bed Category");
    }


    @Test
    public void testFindCategoryByNameReturnOneCategory(){
        //Arrange
        categoriesRepo.deleteAll();
        Category categoryWithParent = Category.builder().name("Bed").parentCategory("Bed Category").build();
        Category savedCategory = categoriesRepo.save(categoryWithParent);
        //Act
        Optional<Category> categoryFound = categoriesRepo.findByName(savedCategory.getName());
        //Assert
        Assertions.assertThat(categoryFound.isPresent()).isTrue();
        Assertions.assertThat(categoryFound.get().getId()).isNotNull();
        Assertions.assertThat(categoryFound.get().getName()).isEqualTo("Bed");
        Assertions.assertThat(categoryFound.get().getParentCategory()).isEqualTo("Bed Category");
    }

    @Test
    public void testFindCategoryByNameReturnNull(){
        //Arrange
        categoriesRepo.deleteAll();
        Category categoryWithParent = Category.builder().name("Bed").parentCategory("Bed Category").build();
        //Act
        Optional<Category> categoryFound = categoriesRepo.findByName("dummyName");
        //Assert
        Assertions.assertThat(categoryFound.isPresent()).isFalse();
    }





}