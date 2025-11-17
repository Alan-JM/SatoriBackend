package com.example.demo.repository;

import com.example.demo.model.Inicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InicioRepository extends JpaRepository<Inicio, Integer> {
}