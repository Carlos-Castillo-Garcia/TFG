package com.app.GestionInmuebles.DTO.Tipos.Inmuebles;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel(value = "Tipo Inmuebles Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TipoInmuebleResponse {
    private int idTipoInmueble;
    private String tipoInmueble;
    private int categoriaId;
    private String categoria;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}
