package com.example.demo.model;

import com.example.demo.model.converter.RolConverter;
import com.example.demo.model.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trabajadores")
public class Trabajadores {

    @Id
    private String codigo;

    @Convert(converter = RolConverter.class)
    @Column(name = "rol")
    private Rol rol;
}