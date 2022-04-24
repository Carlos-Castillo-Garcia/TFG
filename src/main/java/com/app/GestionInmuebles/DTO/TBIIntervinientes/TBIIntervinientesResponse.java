package com.app.GestionInmuebles.DTO.TBIIntervinientes;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesResponse {
    private int intervinientesId;
    private int porcentajePropiedad;
    private int usuarioId;
    private Date createTime;
    private Date updateTime;
    private int clienteId;
    private int contratosId;
    private int tipoIntervinienteId;
}
