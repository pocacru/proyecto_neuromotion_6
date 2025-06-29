package com.neuromotion.ms_usuarios.service;

import com.neuromotion.ms_usuarios.model.Usuario;
import com.neuromotion.ms_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
    public List<Usuario> listar() { return repo.findAll(); }
    public Optional<Usuario> obtener(Long id) { return repo.findById(id); }
    public Usuario guardar(Usuario u) { return repo.save(u); }
    public void eliminar(Long id) { repo.deleteById(id); }
}

