package com.app.GestionInmuebles.DTO.TBIContrato;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
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
    private int idUsuario;
    private int borrado;
    private InmuebleEntity idInmueble;
    private TipoPeriodosEntity idTipoPeriodo;
    private TiposContratoEntity idTipoContrato;
}
