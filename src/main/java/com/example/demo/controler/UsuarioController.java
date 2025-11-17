package com.example.demo.controler;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class usuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioDto>> getAll(@RequestParam(name = "user", required = false) String user) {
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<UsuarioDto> result = usuarios.stream()
                .filter(u -> user == null || user.isEmpty() || u.getUser().equals(user))
                .map(u -> UsuarioDto.builder()
                        .id(u.getId())
                        .user(u.getUser())
                        .nombre(u.getNombre())
                        .password(u.getPassword())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Integer id) {
        Usuario u = usuarioService.getById(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UsuarioDto.builder()
                .id(u.getId())
                .user(u.getUser())
                .nombre(u.getNombre())
                .password(u.getPassword())
                .build());
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto) {
        Usuario u = Usuario.builder()
                .user(usuarioDto.getUser())
                .nombre(usuarioDto.getNombre())
                .password(usuarioDto.getPassword())
                .build();
        Usuario saved = usuarioService.save(u);
        return ResponseEntity.ok(UsuarioDto.builder()
                .id(saved.getId())
                .user(saved.getUser())
                .nombre(saved.getNombre())
                .password(saved.getPassword())
                .build());
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}