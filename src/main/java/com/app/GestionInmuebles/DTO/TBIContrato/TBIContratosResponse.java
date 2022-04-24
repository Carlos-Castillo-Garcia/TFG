package com.app.GestionInmuebles.DTO.TBIContrato;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TBIContratosResponse {
    private int contratoId;
    private Date fechaContrato;
    private float valorContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPeriodo;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int borrado;
    private int inmuebleId;
    private int tipoPeriodoId;
    private int tipoContratoId;
}
