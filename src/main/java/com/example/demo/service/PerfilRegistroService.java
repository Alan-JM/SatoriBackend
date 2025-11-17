package com.example.demo.service;

import com.example.demo.model.PerfilRegistro;
import com.example.demo.model.enums.Rol;

import java.util.List;

    public interface PerfilRegistroService {
        List<PerfilRegistro> getAll();
        PerfilRegistro getById(String telefono);
        PerfilRegistro save(PerfilRegistro perfilRegistro);
        void delete(String telefono);
        Rol getRolByTelefono(String telefono);
    }
