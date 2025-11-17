package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GastosEDto {
    private Integer id;
    private Double combustible;
    private Double casetas;
    private Double comidas;
    private Double reparaciones;
    private Double maniobras;
    private Double transitofederal;
    private Double totale;
}