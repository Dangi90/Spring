package com.ch07.dto;

import lombok.Data;

@Data
public class ProductAggDTO {
    private String priceSum;
    private String priceAvg;
    private String priceMax;
    private String priceMin;
}
