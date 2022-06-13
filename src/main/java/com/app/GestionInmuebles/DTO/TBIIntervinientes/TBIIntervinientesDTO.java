package com.app.GestionInmuebles.DTO.TBIIntervinientes;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Intervinientes Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesDTO {
    private int idInterviniente;
    private int porcentajePropiedad;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int administradorId;
    private int usuarioId;
    private int clienteId;
    private int contratosId;
    private int tipoIntervinienteId;
}
