package com.example.demo.service.impl;

import com.example.demo.model.Folio;
import com.example.demo.repository.FolioRepository;
import com.example.demo.service.FolioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FolioServiceImpl implements FolioService {

    private final FolioRepository folioRepository;

    @Override
    public List<Folio> getAll() {
        return folioRepository.findAll();
    }

    @Override
    public Folio getById(Integer folio) {
        return folioRepository.findById(folio).orElse(null);
    }

    @Override
    public Folio save(Folio folio) {
        return folioRepository.save(folio);
    }

    @Override
    public void delete(Integer folio) {
        folioRepository.deleteById(folio);
    }
}