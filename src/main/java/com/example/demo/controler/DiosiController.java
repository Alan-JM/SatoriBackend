package com.example.demo.controler;

import com.example.demo.dto.DiosiDto;
import com.example.demo.model.Diosi;
import com.example.demo.service.DiosiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class DiosiController {

    private final DiosiService diosiService;

    @GetMapping("/diosi")
    public ResponseEntity<List<DiosiDto>> getAll() {
        List<Diosi> list = diosiService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(d -> DiosiDto.builder()
                        .codigo(d.getCodigo())
                        .contrasena(d.getContrasena())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/diosi/{codigo}")
    public ResponseEntity<DiosiDto> getById(@PathVariable String codigo) {
        Diosi d = diosiService.getById(codigo);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DiosiDto.builder()
                .codigo(d.getCodigo())
                .contrasena(d.getContrasena())
                .build());
    }

    @PostMapping("/diosi")
    public ResponseEntity<DiosiDto> save(@RequestBody DiosiDto dto) {
        Diosi d = Diosi.builder()
                .codigo(dto.getCodigo())
                .contrasena(dto.getContrasena())
                .build();
        diosiService.save(d);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/diosi/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable String codigo) {
        diosiService.delete(codigo);
        return ResponseEntity.ok().build();
    }
}