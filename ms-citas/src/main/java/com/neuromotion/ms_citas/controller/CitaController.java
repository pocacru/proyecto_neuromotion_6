package com.neuromotion.ms_citas.controller;

import com.neuromotion.ms_citas.model.Cita;
import com.neuromotion.ms_citas.dto.CitaDetalleDTO;
import com.neuromotion.ms_citas.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {
    private final CitaService service;
    public CitaController(CitaService service) { this.service = service; }

    @GetMapping public List<Cita> listar() { return service.listar(); }
    @GetMapping("/{id}") public Cita get(@PathVariable Long id) { return service.obtener(id).orElse(null); }
    @PostMapping public Cita crear(@RequestBody Cita c) { return service.guardar(c); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.eliminar(id); }
    @GetMapping("/{id}/detalle") public ResponseEntity<CitaDetalleDTO> detalle(@PathVariable Long id) {
        return service.obtenerDetalle(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
