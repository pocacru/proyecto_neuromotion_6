package com.neuromotion.ms_citas.dto;

import lombok.Data;

@Data
public class CitaDetalleDTO {
    private com.neuromotion.ms_citas.model.Cita cita;
    private UsuarioDTO usuario;
    private DoctorDTO doctor;
}
