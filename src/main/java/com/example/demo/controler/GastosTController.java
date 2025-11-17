package com.example.demo.controler;

import com.example.demo.dto.GastosTDto;
import com.example.demo.model.GastosT;
import com.example.demo.service.GastosTService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class GastosTController {

    private final GastosTService gastosTService;

    @GetMapping("/gastost")
    public ResponseEntity<List<GastosTDto>> getAll() {
        List<GastosT> list = gastosTService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(g -> GastosTDto.builder()
                        .id(g.getId())
                        .combustible(g.getCombustible())
                        .casetas(g.getCasetas())
                        .totalT(g.getTotalT())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/gastost/{id}")
    public ResponseEntity<GastosTDto> getById(@PathVariable Integer id) {
        GastosT g = gastosTService.getById(id);
        if (g == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GastosTDto.builder()
                .id(g.getId())
                .combustible(g.getCombustible())
                .casetas(g.getCasetas())
                .totalT(g.getTotalT())
                .build());
    }

    @PostMapping("/gastost")
    public ResponseEntity<GastosTDto> save(@RequestBody GastosTDto dto) {
        GastosT g = GastosT.builder()
                .id(dto.getId())
                .combustible(dto.getCombustible())
                .casetas(dto.getCasetas())
                .totalT(dto.getTotalT())
                .build();
        gastosTService.save(g);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/gastost/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gastosTService.delete(id);
        return ResponseEntity.ok().build();
    }
}