package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BitacoraDto {
    private Integer id;
    private Integer idInicio;
    private Integer idKilometraje;
    private Integer idGastoTotal;
    private Integer idFolio;
}