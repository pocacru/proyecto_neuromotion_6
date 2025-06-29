package com.neuromotion.ms_doctores.repository;

import com.neuromotion.ms_doctores.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}