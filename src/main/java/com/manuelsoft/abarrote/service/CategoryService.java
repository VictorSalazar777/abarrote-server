package com.manuelsoft.abarrote.service;

import com.manuelsoft.abarrote.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory);

    void deleteCategory(Long categoryId);

}
