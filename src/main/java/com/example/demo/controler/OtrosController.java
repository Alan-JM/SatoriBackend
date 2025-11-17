package com.example.demo.controler;

import com.example.demo.dto.OtrosDto;
import com.example.demo.model.GastosE;
import com.example.demo.model.Otros;
import com.example.demo.service.GastosEService;
import com.example.demo.service.OtrosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class OtrosController {

    private final OtrosService otrosService;
    private final GastosEService gastosEService;

    @GetMapping("/otros")
    public ResponseEntity<List<OtrosDto>> getAll() {
        List<Otros> list = otrosService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(o -> OtrosDto.builder()
                        .id(o.getId())
                        .gasto(o.getGasto())
                        .costo(o.getCosto())
                        .idGastoE(o.getGastoE().getId())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/otros/{id}")
    public ResponseEntity<OtrosDto> getById(@PathVariable Integer id) {
        Otros o = otrosService.getById(id);
        if (o == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(OtrosDto.builder()
                .id(o.getId())
                .gasto(o.getGasto())
                .costo(o.getCosto())
                .idGastoE(o.getGastoE().getId())
                .build());
    }

    @PostMapping("/otros")
    public ResponseEntity<OtrosDto> save(@RequestBody OtrosDto dto) {
        GastosE gastoE = gastosEService.getById(dto.getIdGastoE());
        if (gastoE == null) return ResponseEntity.badRequest().build();

        Otros o = Otros.builder()
                .id(dto.getId())
                .gasto(dto.getGasto())
                .costo(dto.getCosto())
                .gastoE(gastoE)
                .build();

        otrosService.save(o);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/otros/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        otrosService.delete(id);
        return ResponseEntity.ok().build();
    }
}