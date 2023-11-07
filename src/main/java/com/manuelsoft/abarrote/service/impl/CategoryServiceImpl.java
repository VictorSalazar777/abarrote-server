package com.manuelsoft.abarrote.service.impl;

import com.manuelsoft.abarrote.dto.CategoryDto;
import com.manuelsoft.abarrote.exception.ResourceNotFoundException;
import com.manuelsoft.abarrote.mapper.CategoryMapper;
import com.manuelsoft.abarrote.repository.CategoryRepository;
import com.manuelsoft.abarrote.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        var category = CategoryMapper.mapToCategory(categoryDto);
        var createdCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(createdCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Category with id " + categoryId + " not found");
        });
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategoryDto) {
        var category = categoryRepository.findById(categoryId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Category with id " + categoryId + " not found");
        });
        category.setName(updatedCategoryDto.getName());

        var updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Category with id " + categoryId + " not found");
        });
        categoryRepository.delete(category);
    }
}
