package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Ingreso Gasto Detalle Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngresoGastoDetalleDTO {
    private int idInGaDetalle;
    private String conceptoDetalle;
    private float pv;
    private float descuento;
    private int ivaPorcentaje;
    private int cantidad;

    private int inGaId;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
