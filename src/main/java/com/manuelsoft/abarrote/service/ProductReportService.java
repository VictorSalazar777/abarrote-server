package com.manuelsoft.abarrote.service;

import com.manuelsoft.abarrote.dto.ProductReportDto;

import java.util.List;

public interface ProductReportService {

    ProductReportDto createProductReport(ProductReportDto productReportDto);

    ProductReportDto getProductReportById(Long productReportId);

    List<ProductReportDto> getAllProductReports();

    ProductReportDto updateProductReport(Long productReportId, ProductReportDto productReportDto);

    void deleteProductReport(Long productReportId);

}
