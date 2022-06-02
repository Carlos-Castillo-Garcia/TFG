package com.app.GestionInmuebles.DTO.ResponseUnitarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InmueblesXClientesRespone {
    private String apellidos;
    private String nombre;
    private float porcentajePropiedad;
}
