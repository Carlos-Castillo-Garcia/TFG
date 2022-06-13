package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Intervinientes Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IntervinientesResponse {
    private int idTipoInterviniente;
    private String tipoInterviniente;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}
