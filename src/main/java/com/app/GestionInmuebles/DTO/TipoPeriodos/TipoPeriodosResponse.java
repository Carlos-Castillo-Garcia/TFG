package com.app.GestionInmuebles.DTO.TipoPeriodos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TipoPeriodosResponse {
    private int idPeriodo;
    private String tipoPeriodo;
    private Date createTime;
    private Date updateTime;
}
