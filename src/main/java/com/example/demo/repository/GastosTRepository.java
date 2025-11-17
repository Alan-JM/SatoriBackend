package com.example.demo.repository;

import com.example.demo.model.GastosT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosTRepository extends JpaRepository<GastosT, Integer> {
}