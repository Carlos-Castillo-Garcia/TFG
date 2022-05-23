package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle;

import lombok.*;

import java.util.Date;

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

    private int inGaId;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
