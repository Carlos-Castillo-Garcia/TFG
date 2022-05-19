package com.app.GestionInmuebles.DTO.Tipos.Periodos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeriodosResponse {
    private int idTipoPeriodo;
    private String tipoPeriodo;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}

