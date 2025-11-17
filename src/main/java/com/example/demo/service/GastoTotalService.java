package com.example.demo.service;

import com.example.demo.model.GastoTotal;
import java.util.List;

public interface GastoTotalService {
    List<GastoTotal> getAll();
    GastoTotal getById(Integer id);
    GastoTotal save(GastoTotal gastoTotal);
    void delete(Integer id);
}