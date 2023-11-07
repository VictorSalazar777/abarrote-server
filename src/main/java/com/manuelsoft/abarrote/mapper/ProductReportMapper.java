package com.manuelsoft.abarrote.mapper;

import com.manuelsoft.abarrote.dto.ProductReportDto;
import com.manuelsoft.abarrote.entity.ProductReport;

import java.sql.Date;

public class ProductReportMapper {

    public static ProductReportDto mapToProductReportDto(ProductReport productReport) {
        return new ProductReportDto(
                productReport.getId(),
                productReport.getProduct().getId(),
                productReport.getPrice(),
                productReport.getOldPrice(),
                productReport.getExpirationDate().toLocalDate()
        );
    }

    public static ProductReport mapToProductReport(ProductReportDto productReportDto) {

        ProductReport productReport = new ProductReport();
        productReport.setId(productReportDto.getId());
        productReport.setPrice(productReportDto.getPrice());
        productReport.setOldPrice(productReportDto.getOldPrice());
        productReport.setExpirationDate(Date.valueOf(productReportDto.getExpirationDate()));

        return productReport;
    }

}
