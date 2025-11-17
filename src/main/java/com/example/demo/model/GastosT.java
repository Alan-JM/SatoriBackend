package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "GastosT")
public class GastosT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double combustible;
    private Double casetas;

    @Column(name = "totalt")
    private Double totalT;
}