package com.app.GestionInmuebles.DTO.Tipos.Categoria;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;
@ApiModel(value = "Tipo Categoria Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TipoCategoriaResponse {
    private int idCategoria;
    private String categoria;

    private int tipoConceptoId;
    private String tipoConcepto;
    private int tipoInmuebleId;
    private String tipoInmueble;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}
