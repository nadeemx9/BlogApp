package com.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer categoryId;
    @NotEmpty(message = "Category Name should not be empty!")
    @NotBlank(message = "Category Name should not be empty!")
    @Size(min = 3, message = "Category Name must be atleast 3 digits!")
    private String categoryName;
    @NotEmpty(message = "Category Description should not be empty!")
    @NotBlank(message = "Category Description should not be empty!")
    @Size(min = 3, message = "Category Description must be atleast 3 digits!")
    private String categoryDescription;
}
