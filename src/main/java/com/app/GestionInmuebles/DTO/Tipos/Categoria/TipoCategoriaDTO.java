package com.app.GestionInmuebles.DTO.Tipos.Categoria;

import lombok.*;

import java.util.Date;

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
