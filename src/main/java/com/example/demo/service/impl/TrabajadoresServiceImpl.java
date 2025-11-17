package com.example.demo.service.impl;

import com.example.demo.model.Trabajadores;
import com.example.demo.repository.TrabajadoresRepository;
import com.example.demo.service.TrabajadoresService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TrabajadoresServiceImpl implements TrabajadoresService {

    private final TrabajadoresRepository trabajadoresRepository;

    @Override
    public List<Trabajadores> getAll() {
        return trabajadoresRepository.findAll();
    }

    @Override
    public Trabajadores getById(String codigo) {
        return trabajadoresRepository.findById(codigo).orElse(null);
    }

    @Override
    public Trabajadores save(Trabajadores trabajadores) {
        return trabajadoresRepository.save(trabajadores);
    }

    @Override
    public void delete(String codigo) {
        trabajadoresRepository.deleteById(codigo);
    }
}