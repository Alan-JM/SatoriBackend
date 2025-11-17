package com.example.demo.controler;

import com.example.demo.dto.TrabajadoresDto;
import com.example.demo.model.Trabajadores;
import com.example.demo.service.TrabajadoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class TrabajadoresController {

    private final TrabajadoresService trabajadoresService;

    @GetMapping("/trabajadores")
    public ResponseEntity<List<TrabajadoresDto>> getAll() {
        List<Trabajadores> list = trabajadoresService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(t -> TrabajadoresDto.builder()
                        .codigo(t.getCodigo())
                        .rol(t.getRol())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/trabajadores/{codigo}")
    public ResponseEntity<TrabajadoresDto> getById(@PathVariable String codigo) {
        Trabajadores t = trabajadoresService.getById(codigo);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(TrabajadoresDto.builder()
                .codigo(t.getCodigo())
                .rol(t.getRol())
                .build());
    }

    @PostMapping("/trabajadores")
    public ResponseEntity<TrabajadoresDto> save(@RequestBody TrabajadoresDto dto) {
        Trabajadores t = Trabajadores.builder()
                .codigo(dto.getCodigo())
                .rol(dto.getRol())
                .build();
        trabajadoresService.save(t);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/trabajadores/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable String codigo) {
        trabajadoresService.delete(codigo);
        return ResponseEntity.ok().build();
    }
}