package com.app.GestionInmuebles.DTO.Tipos.Periodos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeriodosDTO {
    private int idTipoPeriodo;
    private String tipoPeriodo;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
