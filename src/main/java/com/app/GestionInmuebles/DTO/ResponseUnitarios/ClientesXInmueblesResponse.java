package com.app.GestionInmuebles.DTO.ResponseUnitarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesXInmueblesResponse {
    private String Alias;
    private float porcentajePropiedad;
}
