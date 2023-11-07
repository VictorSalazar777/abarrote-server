package com.manuelsoft.abarrote.service;

import com.manuelsoft.abarrote.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long productId, ProductDto productDto);

    void deleteProduct(Long productId);

}
