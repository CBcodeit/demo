package com.techbook.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    private String id;
    @Nonnull
    private String name;
    private String parentCategory;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Category(String name) {
        this.name = name;
    }

    public Category(@Nonnull String name, String parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
}
