package com.example.demo.service.impl;

import com.example.demo.model.Ayudantes;
import com.example.demo.repository.AyudantesRepository;
import com.example.demo.service.AyudantesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AyudantesServiceImpl implements AyudantesService {

    private final AyudantesRepository ayudantesRepository;

    @Override
    public List<Ayudantes> getAll() {
        return ayudantesRepository.findAll();
    }

    @Override
    public Ayudantes getById(Integer id) {
        return ayudantesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ayudantes> getByInicioId(Integer inicioId) {
        return ayudantesRepository.findByInicioId(inicioId);
    }

    @Override
    public void save(Ayudantes ayudante) {
        ayudantesRepository.save(ayudante);
    }

    @Override
    public void delete(Integer id) {
        ayudantesRepository.deleteById(id);
    }
}