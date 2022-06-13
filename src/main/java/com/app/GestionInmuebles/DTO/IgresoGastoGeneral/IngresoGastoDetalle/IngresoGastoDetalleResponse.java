package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Ingreso Gasto Detalle Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngresoGastoDetalleResponse {
    private int inGaDetalle;
    private String conceptoDetalle;
    private float pv;
    private float descuento;
    private int ivaPorcentaje;
    private int cantidad;
    private float importe;
    private float importeTotal;
    private float valorTotal;

    private int inGaId;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
