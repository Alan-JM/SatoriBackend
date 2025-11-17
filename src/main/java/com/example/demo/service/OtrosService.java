package com.example.demo.service;

import com.example.demo.model.Otros;
import java.util.List;

public interface OtrosService {
    List<Otros> getAll();
    Otros getById(Integer id);
    Otros save(Otros otros);
    void delete(Integer id);
}