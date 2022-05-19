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
public class TipoInmuebleDTO {
    private int idTipoInmueble;
    private String tipoInmueble;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}