package com.manuelsoft.abarrote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReportDto {

    private Long id;
    private Long productId;
    private Float price;
    private Float oldPrice;
    private LocalDate expirationDate;
}
