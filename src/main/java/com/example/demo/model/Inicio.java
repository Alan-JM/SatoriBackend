package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Inicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String cliente;

    @Column(length = 100, nullable = false)
    private String destino;

    @Column(nullable = false)
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "telefono_perfilregistro", referencedColumnName = "telefono", nullable = false, unique = true)
    private PerfilRegistro perfilRegistro;

    @OneToMany(mappedBy = "inicio")
    private List<Ayudantes> ayudantes;
}