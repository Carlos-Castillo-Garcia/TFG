package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@ApiModel(value = "Ingreso Gasto Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresoGastoDTO {
    private int idInGa;
    private String concepto;
    private Date fechaFactura;
    private Date fechaPago;
    private String numeroFactura;
    private float totalBaseImponible;
    private float totalImpuestoIva;
    private float totalGasto;
    private float totalIngreso;
    private String cuentaCorrienteProveedor;
    private String cuentaCorrienteCliente;
    private String conceptoPersonal;

    private int tipoConceptoId;
    private int tipoPagoId;
    private int clienteId;
    private int inmuebleId;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
