package com.app.GestionInmuebles.DTO.Tipos.Contrato;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@ApiModel(value = "Tipo Contrato Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ContratosResponse {
    private int idTipoContrato;
    private String tipoContrato;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}