package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OtrosDto {
    private Integer id;
    private String gasto;
    private Double costo;
    private Integer idGastoE;
}