package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Intervinientes Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IntervinientesDTO {
    private int idTiposInterviniente;
    private String tipoInterviniente;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}

