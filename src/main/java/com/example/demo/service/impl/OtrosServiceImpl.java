package com.example.demo.service.impl;

import com.example.demo.model.Otros;
import com.example.demo.repository.OtrosRepository;
import com.example.demo.service.OtrosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OtrosServiceImpl implements OtrosService {

    private final OtrosRepository otrosRepository;

    @Override
    public List<Otros> getAll() {
        return otrosRepository.findAll();
    }

    @Override
    public Otros getById(Integer id) {
        return otrosRepository.findById(id).orElse(null);
    }

    @Override
    public Otros save(Otros otros) {
        return otrosRepository.save(otros);
    }

    @Override
    public void delete(Integer id) {
        otrosRepository.deleteById(id);
    }
}