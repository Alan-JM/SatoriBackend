package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "GastoTotal")
public class GastoTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_GastosT", unique = true, nullable = false)
    private GastosT gastosT;

    @OneToOne
    @JoinColumn(name = "id_GastosE", unique = true, nullable = false)
    private GastosE gastosE;



    @Column(nullable = false)
    private Double gastoTotal;
}