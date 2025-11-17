package com.example.demo.service.impl;

import com.example.demo.model.Kilometraje;
import com.example.demo.repository.KilometrajeRepository;
import com.example.demo.service.KilometrajeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KilometrajeServiceImpl implements KilometrajeService {

    private final KilometrajeRepository kilometrajeRepository;

    @Override
    public List<Kilometraje> getAll() {
        return kilometrajeRepository.findAll();
    }

    @Override
    public Kilometraje getById(Integer id) {
        return kilometrajeRepository.findById(id).orElse(null);
    }

    @Override
    public Kilometraje save(Kilometraje kilometraje) {
        return kilometrajeRepository.save(kilometraje);
    }

    @Override
    public void delete(Integer id) {
        kilometrajeRepository.deleteById(id);
    }
}