package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Ingreso Gasto Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresoGastoResponse {
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

    private int tipoCategoriaId;
    private String tipoCategoria;
    private int tipoConceptoId;
    private String tipoConcepto;
    private int tipoPagoId;
    private int clienteId;
    private String nombreApellidosCliente;
    private int inmuebleId;
    private String aliasInmueble;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
    private int usuarioId;
    private int administradorId;
}
