package com.example.demo.service.impl;

import com.example.demo.model.GastoTotal;
import com.example.demo.repository.GastoTotalRepository;
import com.example.demo.service.GastoTotalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GastoTotalServiceImpl implements GastoTotalService {

    private final GastoTotalRepository gastoTotalRepository;

    @Override
    public List<GastoTotal> getAll() {
        return gastoTotalRepository.findAll();
    }

    @Override
    public GastoTotal getById(Integer id) {
        return gastoTotalRepository.findById(id).orElse(null);
    }

    @Override
    public GastoTotal save(GastoTotal gastoTotal) {
        return gastoTotalRepository.save(gastoTotal);
    }

    @Override
    public void delete(Integer id) {
        gastoTotalRepository.deleteById(id);
    }
}