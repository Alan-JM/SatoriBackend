package com.example.demo.dto;

import com.example.demo.model.enums.Rol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrabajadoresDto {
    private String codigo;
    private Rol rol;
}