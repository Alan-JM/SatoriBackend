package com.example.demo.repository;

import com.example.demo.model.Ayudantes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AyudantesRepository extends JpaRepository<Ayudantes, Integer> {
    List<Ayudantes> findByInicioId(Integer inicioId);
}