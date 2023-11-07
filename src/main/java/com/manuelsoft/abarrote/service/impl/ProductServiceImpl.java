package com.manuelsoft.abarrote.service.impl;

import com.manuelsoft.abarrote.dto.ProductDto;
import com.manuelsoft.abarrote.exception.ResourceNotFoundException;
import com.manuelsoft.abarrote.mapper.ProductMapper;
import com.manuelsoft.abarrote.repository.CategoryRepository;
import com.manuelsoft.abarrote.repository.ProductRepository;
import com.manuelsoft.abarrote.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = ProductMapper.mapToProduct(productDto);
        var category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(() -> {
            throw new ResourceNotFoundException("Category with id " + productDto.getCategoryId() + " not found");
        });
        product.setCategory(category);
        var createdProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(createdProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> {
            return new ResourceNotFoundException("Product with id: " + productId + " not found");
        });

        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        var products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        var updatedProduct = productRepository.findById(productId).orElseThrow(() -> {
            return new ResourceNotFoundException("Product with id: " + productId + " not found");
        });
        updatedProduct.setName(productDto.getName());

        var category = categoryRepository.getReferenceById(productDto.getCategoryId());
        updatedProduct.setCategory(category);

        updatedProduct = productRepository.save(updatedProduct);

        return ProductMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> {
            return new ResourceNotFoundException("Product with id: " + productId + " not found");
        });
        productRepository.delete(product);
    }
}
