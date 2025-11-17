package com.example.demo.service;

import com.example.demo.model.GastosT;
import java.util.List;

public interface GastosTService {
    List<GastosT> getAll();
    GastosT getById(Integer id);
    GastosT save(GastosT gastosT);
    void delete(Integer id);
}