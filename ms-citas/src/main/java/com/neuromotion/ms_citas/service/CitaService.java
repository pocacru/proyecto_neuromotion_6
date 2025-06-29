package com.neuromotion.ms_citas.service;

import com.neuromotion.ms_citas.dto.*;
import com.neuromotion.ms_citas.model.Cita;
import com.neuromotion.ms_citas.repository.CitaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CitaService {
    private final CitaRepository repo;
    private final RestTemplate rest;

    public CitaService(CitaRepository repo, RestTemplate rest) {
        this.repo = repo;
        this.rest = rest;
    }

    public List<Cita> listar() { return repo.findAll(); }
    public Optional<Cita> obtener(Long id) { return repo.findById(id); }
    public Cita guardar(Cita c) { return repo.save(c); }
    public void eliminar(Long id) { repo.deleteById(id); }

    public Optional<CitaDetalleDTO> obtenerDetalle(Long id) {
        return repo.findById(id).map(c -> {
            UsuarioDTO u = rest.getForObject("http://localhost:8081/usuarios/" + c.getUsuarioId(), UsuarioDTO.class);
            DoctorDTO d = rest.getForObject("http://localhost:8082/doctores/" + c.getDoctorId(), DoctorDTO.class);
            CitaDetalleDTO detalle = new CitaDetalleDTO();
            detalle.setCita(c);
            detalle.setUsuario(u);
            detalle.setDoctor(d);
            return detalle;
        });
    }
}