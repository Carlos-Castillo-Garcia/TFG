package com.app.GestionInmuebles.DTO.Tipos.Pagos;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Pagos Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagosResponse {
    private int idTipoPago;
    private String tipoPagos;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
