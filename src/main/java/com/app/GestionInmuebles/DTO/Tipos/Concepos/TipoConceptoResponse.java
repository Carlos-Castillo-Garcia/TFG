package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel(value = "Tipo Concepto Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TipoConceptoResponse {
    private int idTipoConcepto;
    private String tipoConcepto;
    private int categoriaId;
    private String categoria;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}
