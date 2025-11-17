package com.example.demo.controler;

import com.example.demo.dto.FolioDto;
import com.example.demo.model.Folio;
import com.example.demo.service.FolioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class FolioController {

    private final FolioService folioService;

    @GetMapping("/folio")
    public ResponseEntity<List<FolioDto>> getAll() {
        List<Folio> list = folioService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(f -> FolioDto.builder()
                        .folio(f.getFolio())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/folio/{folio}")
    public ResponseEntity<FolioDto> getById(@PathVariable Integer folio) {
        Folio f = folioService.getById(folio);
        if (f == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(FolioDto.builder()
                .folio(f.getFolio())
                .build());
    }

    @PostMapping("/folio")
    public ResponseEntity<FolioDto> save() {
        Folio f = folioService.save(Folio.builder().build());
        return ResponseEntity.ok(FolioDto.builder()
                .folio(f.getFolio())
                .build());
    }

    @DeleteMapping("/folio/{folio}")
    public ResponseEntity<Void> delete(@PathVariable Integer folio) {
        folioService.delete(folio);
        return ResponseEntity.ok().build();
    }
}