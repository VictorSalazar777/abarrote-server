package com.manuelsoft.abarrote.repository;

import com.manuelsoft.abarrote.entity.Product;
import com.manuelsoft.abarrote.entity.ProductReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReportRepository extends JpaRepository<ProductReport, Long> {
}
