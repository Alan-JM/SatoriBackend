package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GastosTDto {
    private Integer id;
    private Double combustible;
    private Double casetas;
    private Double totalT;
}