package com.example.demo.service;

import com.example.demo.model.GastosE;
import java.util.List;

public interface GastosEService {
    List<GastosE> getAll();
    GastosE getById(Integer id);
    GastosE save(GastosE gastosE);
    void delete(Integer id);
}