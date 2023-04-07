package com.blogapp.services;

import com.blogapp.dto.CategoryDto;
import com.blogapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    CategoryDto getCategoryById(Integer id);
    List<CategoryDto> getAllCategories();
    void deleteCategoryById(Integer id);
}
