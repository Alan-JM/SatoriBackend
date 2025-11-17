package com.example.demo.service;

import com.example.demo.model.Trabajadores;
import java.util.List;

public interface TrabajadoresService {
    List<Trabajadores> getAll();
    Trabajadores getById(String codigo);
    Trabajadores save(Trabajadores trabajadores);
    void delete(String codigo);
}