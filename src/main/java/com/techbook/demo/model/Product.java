package com.techbook.demo.model;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "products")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String id;
    @Size(min = 0, max = 20,message = "Product name must be of length 0 to 20")
    private String name;
    @Size(max = 20,message = "Product description must not exceed length 100")
    private String desc;
    @Min(0)
    private Double price;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Product(String name, String desc, Double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
}
