package com.app.GestionInmuebles.DTO.TBIContrato;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TBIContratosResponse {
    private int idContratos;
    private Date fechaContrato;
    private float valorContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPeriodo;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
    private int inmuebleId;
    private String aliasInmueble;
    private int tipoPeriodoId;
    private String tipoPeriodo;
    private int tipoContratoId;
    private String tipoContrato;
}
