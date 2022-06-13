package com.app.GestionInmuebles.DTO.ResponseUnitarios;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Inmuebles X Clientes Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InmueblesXClientesRespone {
    private String apellidos;
    private String nombre;
    private float porcentajePropiedad;
}
