package com.example.demo.controler;

import com.example.demo.dto.PerfilRegistroDto;
import com.example.demo.model.PerfilRegistro;
import com.example.demo.model.enums.Rol;
import com.example.demo.service.PerfilRegistroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class PerfilRegistroController {

    private final PerfilRegistroService perfilRegistroService;

    @GetMapping("/perfilregistro")
    public ResponseEntity<List<PerfilRegistroDto>> getAll() {
        List<PerfilRegistro> list = perfilRegistroService.getAll();
        return ResponseEntity.ok(list.stream()
                .map(p -> {
                    Rol rol = perfilRegistroService.getRolByTelefono(p.getTelefono());
                    return PerfilRegistroDto.builder()
                            .telefono(p.getTelefono())
                            .nombre(p.getNombre())
                            .imagen(p.getImagen())
                            .fechaNacimiento(p.getFechaNacimiento())
                            .curp(p.getCurp())
                            .nss(p.getNss())
                            .correo(p.getCorreo())
                            .contrasena(p.getContrasena())
                            .codigo(p.getCodigo())
                            .rol(rol) // ← rol obtenido dinámicamente
                            .build();
                })
                .collect(Collectors.toList()));
    }

    @GetMapping("/perfilregistro/{telefono}")
    public ResponseEntity<PerfilRegistroDto> getById(@PathVariable String telefono) {
        PerfilRegistro p = perfilRegistroService.getById(telefono);
        if (p == null) return ResponseEntity.notFound().build();

        Rol rol = perfilRegistroService.getRolByTelefono(telefono);

        return ResponseEntity.ok(PerfilRegistroDto.builder()
                .telefono(p.getTelefono())
                .nombre(p.getNombre())
                .imagen(p.getImagen())
                .fechaNacimiento(p.getFechaNacimiento())
                .curp(p.getCurp())
                .nss(p.getNss())
                .correo(p.getCorreo())
                .contrasena(p.getContrasena())
                .codigo(p.getCodigo())
                .rol(rol) // ← rol obtenido dinámicamente
                .build());
    }

    @PostMapping(value = "/perfilregistro", consumes = "multipart/form-data")
    public ResponseEntity<PerfilRegistroDto> save(
            @RequestPart("dto") PerfilRegistroDto dto,
            @RequestPart(value = "imagen", required = false) MultipartFile imagenFile) {

        byte[] imagenBytes = null;
        try {
            if (imagenFile != null && !imagenFile.isEmpty()) {
                imagenBytes = imagenFile.getBytes();
            }
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }

        PerfilRegistro p = PerfilRegistro.builder()
                .telefono(dto.getTelefono())
                .nombre(dto.getNombre())
                .imagen(imagenBytes)
                .fechaNacimiento(dto.getFechaNacimiento())
                .curp(dto.getCurp())
                .nss(dto.getNss())
                .correo(dto.getCorreo())
                .contrasena(dto.getContrasena())
                .codigo(dto.getCodigo())
                .build();

        perfilRegistroService.save(p);

        Rol rol = perfilRegistroService.getRolByTelefono(p.getTelefono());

        dto.setRol(rol);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/perfilregistro/{telefono}")
    public ResponseEntity<Void> delete(@PathVariable String telefono) {
        perfilRegistroService.delete(telefono);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/perfilregistro/{telefono}/imagen")
    public ResponseEntity<byte[]> getImagen(@PathVariable String telefono) {
        PerfilRegistro perfil = perfilRegistroService.getById(telefono);
        if (perfil == null || perfil.getImagen() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .ok()
                .header("Content-Type", "image/jpeg") // o image/png según el tipo
                .body(perfil.getImagen());
    }

    
    @GetMapping("/perfilregistro/{telefono}/rol")
    public ResponseEntity<String> getRol(@PathVariable String telefono) {
        Rol rol = perfilRegistroService.getRolByTelefono(telefono);
        return rol != null ? ResponseEntity.ok(rol.name()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody PerfilRegistroDto dto) {
        PerfilRegistro perfil = perfilRegistroService.getById(dto.getTelefono());

        if (perfil != null && perfil.getContrasena().equals(dto.getContrasena())) {
            return ResponseEntity.ok(true); // credenciales válidas
        } else {
            return ResponseEntity.ok(false); // credenciales inválidas
        }
    }

}