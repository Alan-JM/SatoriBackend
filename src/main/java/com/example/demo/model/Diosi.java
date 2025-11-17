package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "diosi")
public class Diosi {

    @Id
    @Column(name = "codigo", length = 10)
    private String codigo;

    @Column(name = "contrasena", length = 10)
    private String contrasena;
}