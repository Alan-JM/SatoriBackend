package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class BitacoraFullDto {
    private Integer id;
    private Integer idFolio;
    private Integer idGastoTotal;
    private Integer idInicio;
    private Integer idKilometraje;

    private String folio;

    // GastoTotal
    private Double gastoTotal;
    private Double casetasE;
    private Double combustibleE;
    private Double comidas;
    private Double maniobras;
    private Double reparaciones;
    private Double totale;
    private Double transitofederal;
    private Double casetasT;
    private Double combustibleT;
    private Double totalt;

    // Inicio
    private String cliente;
    private String destino;
    private Date fecha;
    private String telefonoPerfilRegistro;
    private String nombreOperador;
    private String unidadEco;
    private List<String> nombresAyudantes;

    // Ayudantes
    private List<Integer> idAyudantes;

    // Kilometraje
    private Double combustibleConsumido;
    private Double distanciaTotal;
    private Double odometroFinal;
    private Double odometroInicial;
    private Double rendimiento;
}