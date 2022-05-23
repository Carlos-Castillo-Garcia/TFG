package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IntervinientesDTO {
    private int idTiposInterviniente;
    private String tipoInterviniente;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}

