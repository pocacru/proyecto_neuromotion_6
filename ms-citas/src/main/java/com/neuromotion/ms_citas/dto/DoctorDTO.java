package com.neuromotion.ms_citas.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String correo;
}
