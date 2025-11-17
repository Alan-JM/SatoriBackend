package com.example.demo.repository;

import com.example.demo.model.HistorialRegistros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRegistrosRepository extends JpaRepository<HistorialRegistros, Integer> {
}