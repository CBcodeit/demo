package com.techbook.demo.service;

import com.techbook.demo.model.Category;
import com.techbook.demo.repo.CategoriesRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @Mock
    private CategoriesRepo categoriesRepo;

    @InjectMocks
    private CategoryService categoryService;

    private static Category categoryWithParent = Category.builder().name("Bed").parentCategory("Bed Category").build();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public CategoryServiceTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testSaveCategoryReturnSavedCategory() {
        //Arrange
        when(categoriesRepo.save(Mockito.any(Category.class))).thenReturn(categoryWithParent);
        //Act
        Category savedCategoryWithParent = categoryService.saveCategory(categoryWithParent);
        //Assert
        Assertions.assertThat(savedCategoryWithParent).isNotNull();
        Assertions.assertThat(savedCategoryWithParent.getName()).isEqualTo("Bed");
        Assertions.assertThat(savedCategoryWithParent.getParentCategory()).isEqualTo("Bed Category");

    }
}