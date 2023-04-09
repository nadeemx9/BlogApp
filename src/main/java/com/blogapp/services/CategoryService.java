package com.blogapp.services;

import com.blogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    CategoryDto getCategoryById(Integer id);
    List<CategoryDto> getAllCategories();
    void deleteCategoryById(Integer id);
}
