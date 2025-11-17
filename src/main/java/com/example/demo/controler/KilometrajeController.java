package com.example.demo.controler;

import com.example.demo.dto.KilometrajeDto;
import com.example.demo.model.Kilometraje;
import com.example.demo.service.KilometrajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class KilometrajeController {

    private final KilometrajeService kilometrajeService;

    @GetMapping("/kilometraje")
    public ResponseEntity<List<KilometrajeDto>> getAll() {
        List<Kilometraje> list = kilometrajeService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(k -> KilometrajeDto.builder()
                        .id(k.getId())
                        .odometroInicial(k.getOdometroInicial())
                        .odometroFinal(k.getOdometroFinal())
                        .distanciaTotal(k.getDistanciaTotal())
                        .combustibleConsumido(k.getCombustibleConsumido())
                        .rendimiento(k.getRendimiento())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/kilometraje/{id}")
    public ResponseEntity<KilometrajeDto> getById(@PathVariable Integer id) {
        Kilometraje k = kilometrajeService.getById(id);
        if (k == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(KilometrajeDto.builder()
                .id(k.getId())
                .odometroInicial(k.getOdometroInicial())
                .odometroFinal(k.getOdometroFinal())
                .distanciaTotal(k.getDistanciaTotal())
                .combustibleConsumido(k.getCombustibleConsumido())
                .rendimiento(k.getRendimiento())
                .build());
    }

    @PostMapping("/kilometraje")
    public ResponseEntity<KilometrajeDto> save(@RequestBody KilometrajeDto dto) {
        Kilometraje k = Kilometraje.builder()
                .id(dto.getId())
                .odometroInicial(dto.getOdometroInicial())
                .odometroFinal(dto.getOdometroFinal())
                .distanciaTotal(dto.getDistanciaTotal())
                .combustibleConsumido(dto.getCombustibleConsumido())
                .rendimiento(dto.getRendimiento())
                .build();
        kilometrajeService.save(k);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/kilometraje/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        kilometrajeService.delete(id);
        return ResponseEntity.ok().build();
    }
}