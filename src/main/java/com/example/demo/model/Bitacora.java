package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_Inicio", unique = true, nullable = false)
    private Inicio inicio;

    @OneToOne
    @JoinColumn(name = "id_kilometraje", unique = true, nullable = false)
    private Kilometraje kilometraje;

    @OneToOne
    @JoinColumn(name = "id_gastototal", unique = true, nullable = false)
    private GastoTotal gastoTotal;

    @OneToOne
    @JoinColumn(name = "id_folio", unique = true, nullable = false)
    private Folio folio;
}