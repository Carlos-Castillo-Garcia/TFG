package com.app.GestionInmuebles.DTO.Tipos.Categoria;

import lombok.*;

import java.util.Date;
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
