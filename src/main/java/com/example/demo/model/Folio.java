package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Folio")
public class Folio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer folio;
}