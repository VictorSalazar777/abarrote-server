package com.manuelsoft.abarrote.controller;

import com.manuelsoft.abarrote.dto.CategoryDto;
import com.manuelsoft.abarrote.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping({"/abarrote/categories"})
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {

        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);

    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

        var categoriesDto = categoryService.getAllCategories();
        return ResponseEntity.ok(categoriesDto);

    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto) {

        var category = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(category);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {

        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");

    }
}
