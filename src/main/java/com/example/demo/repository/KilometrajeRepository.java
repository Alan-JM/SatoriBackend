package com.example.demo.repository;

import com.example.demo.model.Kilometraje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KilometrajeRepository extends JpaRepository<Kilometraje, Integer> {
}