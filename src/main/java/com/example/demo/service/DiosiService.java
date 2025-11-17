package com.example.demo.service;

import com.example.demo.model.Diosi;
import java.util.List;

public interface DiosiService {
    List<Diosi> getAll();
    Diosi getById(String codigo);
    Diosi save(Diosi diosi);
    void delete(String codigo);
}