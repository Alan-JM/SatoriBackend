package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Integer id;
    private String user;
    private String nombre;
    private String password;
}