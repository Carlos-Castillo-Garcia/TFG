package com.app.GestionInmuebles.DTO.TipoInterviniente;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TipoIntervinienteResponse {
    private int tipoIntervinienteId;
    private String tipoInterviniente;
    private Date createTime;
    private Date updateTime;
}
