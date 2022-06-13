package com.app.GestionInmuebles.DTO.Tipos.Contrato;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Contrato Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratosDTO {
    private int idTipoContrato;
    private String tipoContrato;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}