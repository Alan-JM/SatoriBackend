package com.example.demo.repository;

import com.example.demo.model.Diosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiosiRepository extends JpaRepository<Diosi, String> {
}