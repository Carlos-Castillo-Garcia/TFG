package com.app.GestionInmuebles.DTO.Tipos.Categoria;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Categoria Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TipoCategoriaDTO {
    private int idCategoria;
    private String categoria;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}
