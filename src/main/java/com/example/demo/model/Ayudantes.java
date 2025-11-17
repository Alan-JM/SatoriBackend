package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ayudantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ayudantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_inicio", referencedColumnName = "id")
    private Inicio inicio;
}