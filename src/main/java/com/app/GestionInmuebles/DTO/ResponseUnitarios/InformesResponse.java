package com.app.GestionInmuebles.DTO.ResponseUnitarios;

import io.swagger.annotations.ApiModel;
import lombok.*;

@ApiModel(value = "Informes Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformesResponse {
    private float totalIngresos;
    private float totalGastos;
    private float totalBalance;
    private int idInmueble;
    private String inmuebleAlias;
    private String anio;
    private String nombreMes;
    private String numeroMes;
}
