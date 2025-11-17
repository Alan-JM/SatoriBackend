package com.example.demo.service.impl;

import com.example.demo.model.HistorialRegistros;
import com.example.demo.repository.HistorialRegistrosRepository;
import com.example.demo.service.HistorialRegistrosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HistorialRegistrosServiceImpl implements HistorialRegistrosService {

    private final HistorialRegistrosRepository historialRegistrosRepository;

    @Override
    public List<HistorialRegistros> getAll() {
        return historialRegistrosRepository.findAll();
    }

    @Override
    public HistorialRegistros getById(Integer id) {
        return historialRegistrosRepository.findById(id).orElse(null);
    }

    @Override
    public HistorialRegistros save(HistorialRegistros historialRegistros) {
        return historialRegistrosRepository.save(historialRegistros);
    }

    @Override
    public void delete(Integer id) {
        historialRegistrosRepository.deleteById(id);
    }
}