package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class InicioDto {
    private Integer id;
    private String cliente;
    private String destino;
    private Date fecha;
    private String telefonoPerfilRegistro; // clave del perfil relacionado
}