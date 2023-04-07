package com.blogapp.controllers;

import com.blogapp.dto.CategoryDto;
import com.blogapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto)
    {
        return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto, @PathVariable Integer id)
    {
        return new ResponseEntity<CategoryDto>(categoryService.updateCategory(categoryDto, id), HttpStatus.ACCEPTED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id)
    {
        return new ResponseEntity<CategoryDto>(categoryService.getCategoryById(id), HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategories(), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id)
    {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<String>("Category with ID '"+id+"' Deleted", HttpStatus.OK);
    }
}
