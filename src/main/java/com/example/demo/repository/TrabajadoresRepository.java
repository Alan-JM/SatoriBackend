package com.example.demo.repository;

import com.example.demo.model.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores, String> {
}