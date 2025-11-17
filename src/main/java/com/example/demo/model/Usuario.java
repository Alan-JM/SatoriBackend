package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user", nullable = false, length = 50)
    private String user;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "password", nullable = false, length = 100)
    private String password;
}