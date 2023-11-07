package com.manuelsoft.abarrote.repository;

import com.manuelsoft.abarrote.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
