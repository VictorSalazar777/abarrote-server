package com.manuelsoft.abarrote.controller;

import com.manuelsoft.abarrote.dto.ProductReportDto;
import com.manuelsoft.abarrote.service.ProductReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/abarrote/product-report")
public class ProductReportController {

    private ProductReportService productReportService;

    @PostMapping
    public ResponseEntity<ProductReportDto> createProductReport(@RequestBody ProductReportDto productReportDto) {

        var createdProductReportDto = productReportService.createProductReport(productReportDto);
        return ResponseEntity.ok(createdProductReportDto);

    }

    @GetMapping("{id}")
    public ResponseEntity<ProductReportDto> getProductReportById(@PathVariable("id") Long productReportId) {

        var productReportDto = productReportService.getProductReportById(productReportId);
        return ResponseEntity.ok(productReportDto);

    }

    @GetMapping
    public ResponseEntity<List<ProductReportDto>> getAllProductReports() {

        var productReportsDto = productReportService.getAllProductReports();
        return ResponseEntity.ok(productReportsDto);

    }

    @PutMapping("{id}")
    public ResponseEntity<ProductReportDto> updateProductReport(@PathVariable("id") Long productReportId,
                                                                @RequestBody ProductReportDto productReportDto) {

        var updatedProductReport = productReportService.updateProductReport(productReportId, productReportDto);
        return ResponseEntity.ok(updatedProductReport);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductReport(@PathVariable("id") Long productReportId) {

        productReportService.deleteProductReport(productReportId);
        return ResponseEntity.ok("Product report deleted successfully");

    }
}
