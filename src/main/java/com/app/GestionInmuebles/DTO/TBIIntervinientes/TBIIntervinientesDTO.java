package com.app.GestionInmuebles.DTO.TBIIntervinientes;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesDTO {
    private int idInterviniente;
    private int porcentajePropiedad;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int administradorId;
    private int usuarioId;
    private int clienteId;
    private int contratosId;
    private int tipoIntervinienteId;
}
