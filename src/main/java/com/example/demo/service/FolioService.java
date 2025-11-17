package com.example.demo.service;

import com.example.demo.model.Folio;
import java.util.List;

public interface FolioService {
    List<Folio> getAll();
    Folio getById(Integer folio);
    Folio save(Folio folio);
    void delete(Integer folio);
}