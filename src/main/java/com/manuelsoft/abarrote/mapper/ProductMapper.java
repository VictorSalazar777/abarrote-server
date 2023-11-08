package com.manuelsoft.abarrote.mapper;

import com.manuelsoft.abarrote.dto.ProductDto;
import com.manuelsoft.abarrote.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getCategory().getId(),
                product.getPrice()
        );
    }

    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }

}
