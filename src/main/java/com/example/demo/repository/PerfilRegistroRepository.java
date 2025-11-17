package com.example.demo.repository;

import com.example.demo.model.PerfilRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRegistroRepository extends JpaRepository<PerfilRegistro, String> {
    PerfilRegistro findByTelefono(String telefono);
}