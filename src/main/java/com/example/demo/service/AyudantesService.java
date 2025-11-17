package com.example.demo.service;

import com.example.demo.model.Ayudantes;

import java.util.List;

public interface AyudantesService {
    List<Ayudantes> getAll();
    Ayudantes getById(Integer id);
    List<Ayudantes> getByInicioId(Integer inicioId);
    void save(Ayudantes ayudante);
    void delete(Integer id);
}