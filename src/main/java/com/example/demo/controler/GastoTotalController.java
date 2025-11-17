package com.example.demo.controler;

import com.example.demo.dto.GastoTotalDto;
import com.example.demo.model.GastoTotal;
import com.example.demo.model.GastosE;
import com.example.demo.model.GastosT;
import com.example.demo.service.GastoTotalService;
import com.example.demo.service.GastosEService;
import com.example.demo.service.GastosTService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class GastoTotalController {

    private final GastoTotalService gastoTotalService;
    private final GastosTService gastosTService;
    private final GastosEService gastosEService;

    @GetMapping("/gastototal")
    public ResponseEntity<List<GastoTotalDto>> getAll() {
        List<GastoTotal> list = gastoTotalService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(g -> GastoTotalDto.builder()
                        .id(g.getId())
                        .idGastosT(g.getGastosT().getId())
                        .idGastosE(g.getGastosE().getId())
                        .gastoTotal(g.getGastoTotal())
                        .build())
                .collect(Collectors.toList()));
    }

    @GetMapping("/gastototal/{id}")
    public ResponseEntity<GastoTotalDto> getById(@PathVariable Integer id) {
        GastoTotal g = gastoTotalService.getById(id);
        if (g == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(GastoTotalDto.builder()
                .id(g.getId())
                .idGastosT(g.getGastosT().getId())
                .idGastosE(g.getGastosE().getId())
                .gastoTotal(g.getGastoTotal())
                .build());
    }

    @PostMapping("/gastototal")
    public ResponseEntity<GastoTotalDto> save(@RequestBody GastoTotalDto dto) {
        GastosT gastosT = gastosTService.getById(dto.getIdGastosT());
        GastosE gastosE = gastosEService.getById(dto.getIdGastosE());

        if (gastosT == null || gastosE == null) return ResponseEntity.badRequest().build();

        GastoTotal g = GastoTotal.builder()
                .id(dto.getId())
                .gastosT(gastosT)
                .gastosE(gastosE)
                .gastoTotal(dto.getGastoTotal())
                .build();

        gastoTotalService.save(g);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/gastototal/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gastoTotalService.delete(id);
        return ResponseEntity.ok().build();
    }
}