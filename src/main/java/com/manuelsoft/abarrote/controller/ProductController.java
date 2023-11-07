package com.manuelsoft.abarrote.controller;

import com.manuelsoft.abarrote.dto.ProductDto;
import com.manuelsoft.abarrote.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/abarrote/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {

        var createdProductDto = productService.createProduct(productDto);
        return ResponseEntity.ok(createdProductDto);

    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {

        var productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);

    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {

        var productsDto = productService.getAllProducts();
        return ResponseEntity.ok(productsDto);

    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId,
                                                    @RequestBody ProductDto productDto) {

        var updatedProductDto = productService.updateProduct(productId, productDto);
        return ResponseEntity.ok(updatedProductDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {

        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");

    }
}
