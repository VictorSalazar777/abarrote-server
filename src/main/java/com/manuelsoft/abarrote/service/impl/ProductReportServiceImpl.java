package com.manuelsoft.abarrote.service.impl;

import com.manuelsoft.abarrote.dto.ProductReportDto;
import com.manuelsoft.abarrote.exception.ResourceNotFoundException;
import com.manuelsoft.abarrote.mapper.ProductReportMapper;
import com.manuelsoft.abarrote.repository.ProductReportRepository;
import com.manuelsoft.abarrote.repository.ProductRepository;
import com.manuelsoft.abarrote.service.ProductReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductReportServiceImpl implements ProductReportService {

    private ProductReportRepository productReportRepository;
    private ProductRepository productRepository;

    @Override
    public ProductReportDto createProductReport(ProductReportDto productReportDto) {
        var productReport = ProductReportMapper.mapToProductReport(productReportDto);
        var product = productRepository.findById(productReportDto.getProductId()).orElseThrow(() -> {
            return new ResourceNotFoundException("Product with id: " + productReportDto.getProductId() + " not found");
        });
        productReport.setProduct(product);
        productReport = productReportRepository.save(productReport);
        return ProductReportMapper.mapToProductReportDto(productReport);
    }

    @Override
    public ProductReportDto getProductReportById(Long productReportId) {
        var productReport = productReportRepository.findById(productReportId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Product report with id: " + productReportId + "not found");
        });
        return ProductReportMapper.mapToProductReportDto(productReport);
    }

    @Override
    public List<ProductReportDto> getAllProductReports() {
        var productReports = productReportRepository.findAll();
        return productReports.stream().map(ProductReportMapper::mapToProductReportDto).collect(Collectors.toList());
    }

    @Override
    public ProductReportDto updateProductReport(Long productReportId, ProductReportDto productReportDto) {
        var productReport = productReportRepository.findById(productReportId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Product report with id: " + productReportId + "not found");
        });
        productReport.setProduct(productRepository.getReferenceById(productReportDto.getProductId()));
        productReport.setPrice(productReportDto.getPrice());
        productReport.setOldPrice(productReportDto.getOldPrice());
        productReport.setExpirationDate(Date.valueOf(productReportDto.getExpirationDate()));
        productReport = productReportRepository.save(productReport);
        return ProductReportMapper.mapToProductReportDto(productReport);
    }

    @Override
    public void deleteProductReport(Long productReportId) {
        var productReport = productReportRepository.findById(productReportId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Product report with id: " + productReportId + "not found");
        });
        productReportRepository.delete(productReport);
    }
}
