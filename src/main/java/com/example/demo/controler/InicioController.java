package com.example.demo.controler;

import com.example.demo.dto.InicioDto;
import com.example.demo.model.Inicio;
import com.example.demo.model.PerfilRegistro;
import com.example.demo.service.InicioService;
import com.example.demo.service.PerfilRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Aristo/api/inicio")
@RequiredArgsConstructor
public class InicioController {

    private final InicioService inicioService;
    private final PerfilRegistroService perfilRegistroService;

    @GetMapping
    public ResponseEntity<List<InicioDto>> getAll() {
        return ResponseEntity.ok(
                inicioService.getAll().stream().map(i -> InicioDto.builder()
                        .id(i.getId())
                        .cliente(i.getCliente())
                        .destino(i.getDestino())
                        .fecha(i.getFecha())
                        .telefonoPerfilRegistro(i.getPerfilRegistro().getTelefono())
                        .build()
                ).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InicioDto> getById(@PathVariable Integer id) {
        Inicio i = inicioService.getById(id);
        if (i == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(InicioDto.builder()
                .id(i.getId())
                .cliente(i.getCliente())
                .destino(i.getDestino())
                .fecha(i.getFecha())
                .telefonoPerfilRegistro(i.getPerfilRegistro().getTelefono())
                .build());
    }

    @PostMapping
    public ResponseEntity<InicioDto> save(@RequestBody InicioDto dto) {
        PerfilRegistro perfil = perfilRegistroService.getByTelefono(dto.getTelefonoPerfilRegistro());
        if (perfil == null) return ResponseEntity.badRequest().build();

        Inicio i = Inicio.builder()
                .id(dto.getId())
                .cliente(dto.getCliente())
                .destino(dto.getDestino())
                .fecha(dto.getFecha())
                .perfilRegistro(perfil)
                .build();

        inicioService.save(i);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        inicioService.delete(id);
        return ResponseEntity.ok().build();
    }
}