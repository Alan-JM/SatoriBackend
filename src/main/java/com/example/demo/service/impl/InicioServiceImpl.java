package com.example.demo.service.impl;

import com.example.demo.model.Inicio;
import com.example.demo.repository.InicioRepository;
import com.example.demo.service.InicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InicioServiceImpl implements InicioService {

    private final InicioRepository inicioRepository;

    @Override
    public List<Inicio> getAll() {
        return inicioRepository.findAll();
    }

    @Override
    public Inicio getById(Integer id) {
        return inicioRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Inicio inicio) {
        inicioRepository.save(inicio);
    }

    @Override
    public void delete(Integer id) {
        inicioRepository.deleteById(id);
    }
}