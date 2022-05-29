package com.app.GestionInmuebles.DTO.Tipos.Inmuebles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
