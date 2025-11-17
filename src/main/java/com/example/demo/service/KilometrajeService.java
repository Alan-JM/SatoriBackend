package com.example.demo.service;

import com.example.demo.model.Kilometraje;
import java.util.List;

public interface KilometrajeService {
    List<Kilometraje> getAll();
    Kilometraje getById(Integer id);
    Kilometraje save(Kilometraje kilometraje);
    void delete(Integer id);
}