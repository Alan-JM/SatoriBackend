package com.example.demo.service.impl;

import com.example.demo.model.GastosE;
import com.example.demo.repository.GastosERepository;
import com.example.demo.service.GastosEService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GastosEServiceImpl implements GastosEService {

    private final GastosERepository gastosERepository;

    @Override
    public List<GastosE> getAll() {
        return gastosERepository.findAll();
    }

    @Override
    public GastosE getById(Integer id) {
        return gastosERepository.findById(id).orElse(null);
    }

    @Override
    public GastosE save(GastosE gastosE) {
        return gastosERepository.save(gastosE);
    }

    @Override
    public void delete(Integer id) {
        gastosERepository.deleteById(id);
    }
}