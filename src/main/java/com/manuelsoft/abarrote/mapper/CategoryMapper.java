package com.manuelsoft.abarrote.mapper;

import com.manuelsoft.abarrote.dto.CategoryDto;
import com.manuelsoft.abarrote.entity.Category;

public class CategoryMapper {

    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getName()
        );
    }

}
