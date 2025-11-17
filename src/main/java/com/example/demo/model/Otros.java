package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Otros")
public class Otros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String gasto;

    @Column(nullable = false)
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "id_gastoE", nullable = false)
    private GastosE gastoE;
}