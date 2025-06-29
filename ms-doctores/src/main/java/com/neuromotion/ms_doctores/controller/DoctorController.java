package com.neuromotion.ms_doctores.controller;

import com.neuromotion.ms_doctores.model.Doctor;
import com.neuromotion.ms_doctores.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
    private final DoctorService service;
    public DoctorController(DoctorService service) {
        this.service = service;
    }
    @GetMapping public List<Doctor> listar() { return service.listar(); }
    @GetMapping("/{id}") public Doctor get(@PathVariable Long id) { return service.obtener(id).orElse(null); }
    @PostMapping public Doctor crear(@RequestBody Doctor d) { return service.guardar(d); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}

