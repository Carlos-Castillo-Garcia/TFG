package com.app.GestionInmuebles.DTO.TBIContrato;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TBIContratosDTO {
    private Date fechaContrato;
    private float valorContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPeriodo;
    private int idInmueble;
    private int idTipoPeriodo;
    private int idTipoContrato;
}
