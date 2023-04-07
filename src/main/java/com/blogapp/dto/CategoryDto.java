package com.blogapp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;
    @NotEmpty(message = "Category Name should not be empty!")
    @Size(min = 3, message = "Category Name must be atleast 3 digits!")
    String categoryName;
    @NotEmpty(message = "Category Description should not be empty!")
    @Size(min = 3, message = "Category Description must be atleast 3 digits!")
    String categoryDescription;
}
