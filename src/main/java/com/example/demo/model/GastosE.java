package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "GastosE")
public class GastosE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double combustible;
    private Double casetas;
    private Double comidas;
    private Double reparaciones;
    private Double maniobras;
    private Double transitofederal;
    private Double totale;
}