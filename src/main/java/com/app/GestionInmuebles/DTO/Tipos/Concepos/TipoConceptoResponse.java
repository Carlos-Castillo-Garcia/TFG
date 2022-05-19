package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TipoConceptoResponse {
    private int idTipoConcepto;
    private String tipoConcepto;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}
