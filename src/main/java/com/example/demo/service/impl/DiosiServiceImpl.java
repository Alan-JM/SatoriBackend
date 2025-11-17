package com.example.demo.service.impl;

import com.example.demo.model.Diosi;
import com.example.demo.repository.DiosiRepository;
import com.example.demo.service.DiosiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DiosiServiceImpl implements DiosiService {

    private final DiosiRepository diosiRepository;

    @Override
    public List<Diosi> getAll() {
        return diosiRepository.findAll();
    }

    @Override
    public Diosi getById(String codigo) {
        return diosiRepository.findById(codigo).orElse(null);
    }

    @Override
    public Diosi save(Diosi diosi) {
        return diosiRepository.save(diosi);
    }

    @Override
    public void delete(String codigo) {
        diosiRepository.deleteById(codigo);
    }
}