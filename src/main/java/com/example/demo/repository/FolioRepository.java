package com.example.demo.repository;

import com.example.demo.model.Folio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolioRepository extends JpaRepository<Folio, Integer> {
}