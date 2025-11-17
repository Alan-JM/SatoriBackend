package com.example.demo.controler;

import com.example.demo.dto.GastosEDto;
import com.example.demo.model.GastosE;
import com.example.demo.service.GastosEService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class GastosEController {

    private final GastosEService gastosEService;

    @GetMapping("/gastose")
    public ResponseEntity<List<GastosEDto>> getAll() {
        List<GastosE> list = gastosEService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(g -> GastosEDto.builder()
                        .id(g.getId())
                        .combustible(g.getCombustible())
                        .casetas(g.getCasetas())
                        .comidas(g.getComidas())
                        .reparaciones(g.getReparaciones())
                        .maniobras(g.getManiobras())
                        .transitofederal(g.getTransitofederal())
                        .totale(g.getTotale())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/gastose/{id}")
    public ResponseEntity<GastosEDto> getById(@PathVariable Integer id) {
        GastosE g = gastosEService.getById(id);
        if (g == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GastosEDto.builder()
                .id(g.getId())
                .combustible(g.getCombustible())
                .casetas(g.getCasetas())
                .comidas(g.getComidas())
                .reparaciones(g.getReparaciones())
                .maniobras(g.getManiobras())
                .transitofederal(g.getTransitofederal())
                .totale(g.getTotale())
                .build());
    }

    @PostMapping("/gastose")
    public ResponseEntity<GastosEDto> save(@RequestBody GastosEDto dto) {
        GastosE g = GastosE.builder()
                .id(dto.getId())
                .combustible(dto.getCombustible())
                .casetas(dto.getCasetas())
                .comidas(dto.getComidas())
                .reparaciones(dto.getReparaciones())
                .maniobras(dto.getManiobras())
                .transitofederal(dto.getTransitofederal())
                .totale(dto.getTotale())
                .build();
        gastosEService.save(g);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/gastose/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gastosEService.delete(id);
        return ResponseEntity.ok().build();
    }
}