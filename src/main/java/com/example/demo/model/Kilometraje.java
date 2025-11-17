package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Kilometraje")
public class Kilometraje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double odometroInicial;

    @Column(nullable = false)
    private Double odometroFinal;

    @Column(nullable = false)
    private Double distanciaTotal;

    private Double combustibleConsumido;
    private Double rendimiento;
}