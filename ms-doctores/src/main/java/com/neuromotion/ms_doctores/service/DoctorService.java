package com.neuromotion.ms_doctores.service;

import com.neuromotion.ms_doctores.model.Doctor;
import com.neuromotion.ms_doctores.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {
    private final DoctorRepository repo;
    public DoctorService(DoctorRepository repo) {
        this.repo = repo;
    }
    public List<Doctor> listar() { return repo.findAll(); }
    public Optional<Doctor> obtener(Long id) { return repo.findById(id); }
    public Doctor guardar(Doctor d) { return repo.save(d); }
    public void eliminar(Long id) { repo.deleteById(id); }
}

