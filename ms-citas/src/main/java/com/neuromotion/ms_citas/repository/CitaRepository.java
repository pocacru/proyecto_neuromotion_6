package com.neuromotion.ms_citas.repository;

import com.neuromotion.ms_citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {}