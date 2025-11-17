package com.example.demo.controler;

import com.example.demo.dto.AyudantesDto;
import com.example.demo.model.Ayudantes;
import com.example.demo.model.Inicio;
import com.example.demo.service.AyudantesService;
import com.example.demo.service.InicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Aristo/api/ayudantes")
@RequiredArgsConstructor
public class AyudantesController {

    private final AyudantesService ayudantesService;
    private final InicioService inicioService;

    @GetMapping
    public ResponseEntity<List<AyudantesDto>> getAll() {
        return ResponseEntity.ok(
                ayudantesService.getAll().stream().map(a -> AyudantesDto.builder()
                        .id(a.getId())
                        .nombre(a.getNombre())
                        .idInicio(a.getInicio().getId())
                        .build()
                ).collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<AyudantesDto> save(@RequestBody AyudantesDto dto) {
        Inicio inicio = inicioService.getById(dto.getIdInicio());
        if (inicio == null) return ResponseEntity.badRequest().build();

        Ayudantes a = Ayudantes.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .inicio(inicio)
                .build();

        ayudantesService.save(a);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ayudantesService.delete(id);
        return ResponseEntity.ok().build();
    }
}