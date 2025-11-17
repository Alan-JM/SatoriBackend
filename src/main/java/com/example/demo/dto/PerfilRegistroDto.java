package com.example.demo.dto;

import com.example.demo.model.enums.Rol;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class PerfilRegistroDto {
    private String telefono;
    private String nombre;
    private byte[] imagen;
    private Date fechaNacimiento;
    private String curp;
    private String nss;
    private String correo;
    private String contrasena;
    private String codigo;
    private Rol rol;

}