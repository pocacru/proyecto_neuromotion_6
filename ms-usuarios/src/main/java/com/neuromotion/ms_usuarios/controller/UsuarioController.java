package com.neuromotion.ms_usuarios.controller;

import com.neuromotion.ms_usuarios.model.Usuario;
import com.neuromotion.ms_usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @GetMapping public List<Usuario> listar() { return service.listar(); }
    @GetMapping("/{id}") public Usuario get(@PathVariable Long id) { return service.obtener(id).orElse(null); }
    @PostMapping public Usuario crear(@RequestBody Usuario u) { return service.guardar(u); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}