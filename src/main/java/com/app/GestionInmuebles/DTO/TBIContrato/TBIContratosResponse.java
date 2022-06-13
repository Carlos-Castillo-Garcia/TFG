package com.app.GestionInmuebles.DTO.TBIContrato;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Contrato Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
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
