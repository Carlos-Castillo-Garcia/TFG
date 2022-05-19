package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IntervinientesResponse {
    private int idTipoInterviniente;
    private String tipoInterviniente;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}
