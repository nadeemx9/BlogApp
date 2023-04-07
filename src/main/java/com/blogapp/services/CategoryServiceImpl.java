package com.blogapp.services;

import com.blogapp.dto.CategoryDto;
import com.blogapp.dto.UserDto;
import com.blogapp.entities.Category;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return categoryToDto(categoryRepository.save(dtoToCategory(categoryDto)));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id)
    {
        if(categoryRepository.existsById(id)) {
            Category category = categoryRepository.findById(id).get();
            category.setCategoryName(categoryDto.getCategoryName());
            category.setCategoryDescription(categoryDto.getCategoryDescription());
            return categoryToDto(categoryRepository.save(category));
        }
        else
            throw new ResourceNotFoundException("Category with ID '"+id+"' not found!");
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        if(categoryRepository.existsById(id))
            return categoryToDto(categoryRepository.findById(id).get());
        else
            throw new ResourceNotFoundException("Category with ID '"+id+"' not found!");
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categories = categoriesToDtos(categoryRepository.findAll());
        return categories;
    }

    @Override
    public void deleteCategoryById(Integer id) {
        if(categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Category with ID '"+id+"' not found!");
    }

    public Category dtoToCategory(CategoryDto categoryDto)
    {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }

    public CategoryDto categoryToDto(Category category)
    {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    public List<CategoryDto> categoriesToDtos(List<Category> categories)
    {
        List<CategoryDto> dtos = modelMapper.map(categories, new TypeToken<List<CategoryDto>>() {}.getType());
        return dtos;
    }
}
