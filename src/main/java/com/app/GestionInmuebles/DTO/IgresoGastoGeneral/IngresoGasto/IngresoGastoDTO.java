package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresoGastoDTO {
    private Long idInGa;
    private Date fechaConcepto;
    private String concepto;
    private float ingreso;
    private int ivaPorcentaje;
    private float gasto;
    private Date fechaFactura;
    private String numeroFactura;

    private int tipoConceptoId;
    private int proveedorId;
    private int inmuebleId;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
