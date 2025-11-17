package com.example.demo.repository;

import com.example.demo.model.GastoTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoTotalRepository extends JpaRepository<GastoTotal, Integer> {
}