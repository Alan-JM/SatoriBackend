package com.example.demo.service.impl;

import com.example.demo.model.PerfilRegistro;
import com.example.demo.model.Trabajadores;
import com.example.demo.model.enums.Rol;
import com.example.demo.repository.PerfilRegistroRepository;
import com.example.demo.repository.TrabajadoresRepository;
import com.example.demo.service.PerfilRegistroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PerfilRegistroServiceImpl implements PerfilRegistroService {

    private final PerfilRegistroRepository perfilRegistroRepository;
    private final TrabajadoresRepository trabajadorRepository;

    @Override
    public List<PerfilRegistro> getAll() {
        return perfilRegistroRepository.findAll();
    }

    @Override
    public PerfilRegistro getById(String telefono) {
        return perfilRegistroRepository.findById(telefono).orElse(null);
    }

    @Override
    public PerfilRegistro getByTelefono(String telefono) {

        return perfilRegistroRepository.findById(telefono).orElse(null);
    }

    @Override
    public PerfilRegistro save(PerfilRegistro perfilRegistro) {
        return perfilRegistroRepository.save(perfilRegistro);
    }

    @Override
    public void delete(String telefono) {
        perfilRegistroRepository.deleteById(telefono);
    }

    @Override
    public Rol getRolByTelefono(String telefono) {
        PerfilRegistro perfil = getByTelefono(telefono);
        if (perfil == null) return null;

        Trabajadores trabajadores = trabajadorRepository.findById(perfil.getCodigo()).orElse(null);
        return trabajadores != null ? trabajadores.getRol() : null;
    }
}