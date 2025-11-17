package com.example.demo.service.impl;

import com.example.demo.model.GastosT;
import com.example.demo.repository.GastosTRepository;
import com.example.demo.service.GastosTService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GastosTServiceImpl implements GastosTService {

    private final GastosTRepository gastosTRepository;

    @Override
    public List<GastosT> getAll() {
        return gastosTRepository.findAll();
    }

    @Override
    public GastosT getById(Integer id) {
        return gastosTRepository.findById(id).orElse(null);
    }

    @Override
    public GastosT save(GastosT gastosT) {
        return gastosTRepository.save(gastosT);
    }

    @Override
    public void delete(Integer id) {
        gastosTRepository.deleteById(id);
    }
}