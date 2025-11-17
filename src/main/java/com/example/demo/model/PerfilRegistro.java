package com.example.demo.model;

import com.example.demo.model.enums.Rol;
import com.example.demo.model.converter.RolConverter;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "perfilregistro")
public class PerfilRegistro {

    @Id
    @Column(name = "telefono", length = 15)
    private String telefono;

    private String nombre;
    private byte[] imagen;

    @Column(name = "fecha_nacimiento")
    private java.sql.Date fechaNacimiento;

    private String curp;
    private String nss;
    private String correo;
    private String contrasena;
    private String codigo;

}