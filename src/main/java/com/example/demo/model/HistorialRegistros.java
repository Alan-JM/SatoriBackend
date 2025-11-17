package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "historialRegistros")
public class HistorialRegistros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "fechaRegistro")
    private java.sql.Timestamp fechaRegistro;
}