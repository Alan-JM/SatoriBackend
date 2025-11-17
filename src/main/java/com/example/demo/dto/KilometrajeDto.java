package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KilometrajeDto {
    private Integer id;
    private Double odometroInicial;
    private Double odometroFinal;
    private Double distanciaTotal;
    private Double combustibleConsumido;
    private Double rendimiento;
}