package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class HistorialRegistrosDto {
    private Integer id;
    private String telefono;
    private String nombre;
    private Timestamp fechaRegistro;
}