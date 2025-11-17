package com.example.demo.service;

import com.example.demo.model.HistorialRegistros;
import java.util.List;

public interface HistorialRegistrosService {
    List<HistorialRegistros> getAll();
    HistorialRegistros getById(Integer id);
    HistorialRegistros save(HistorialRegistros historialRegistros);
    void delete(Integer id);
}