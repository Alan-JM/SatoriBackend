package com.example.demo.service;

import com.example.demo.model.Inicio;

import java.util.List;

public interface InicioService {
    List<Inicio> getAll();
    Inicio getById(Integer id);
    void save(Inicio inicio);
    void delete(Integer id);
}