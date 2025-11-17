package com.example.demo.controler;

import com.example.demo.dto.HistorialRegistrosDto;
import com.example.demo.model.HistorialRegistros;
import com.example.demo.service.HistorialRegistrosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class HistorialRegistrosController {

    private final HistorialRegistrosService historialRegistrosService;

    @GetMapping("/historialregistros/{id}")
    public ResponseEntity<HistorialRegistrosDto> getById(@PathVariable Integer id) {
        HistorialRegistros h = historialRegistrosService.getById(id);
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(HistorialRegistrosDto.builder()
                .id(h.getId())
                .telefono(h.getTelefono())
                .nombre(h.getNombre())
                .fechaRegistro(h.getFechaRegistro())
                .build());
    }
}