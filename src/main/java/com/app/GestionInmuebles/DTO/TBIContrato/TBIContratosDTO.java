package com.app.GestionInmuebles.DTO.TBIContrato;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Contrato Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TBIContratosDTO {
    private int idContratos;
    private Date fechaContrato;
    private float valorContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPeriodo;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
    private int inmuebleId;
    private int tipoPeriodoId;
    private int tipoContratoId;
}
