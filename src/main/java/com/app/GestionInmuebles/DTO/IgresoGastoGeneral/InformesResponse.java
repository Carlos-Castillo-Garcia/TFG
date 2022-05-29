package com.app.GestionInmuebles.DTO.IgresoGastoGeneral;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
