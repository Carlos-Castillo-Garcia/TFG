package com.app.GestionInmuebles.DTO.TBIIntervinientes;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesResponse {
    private int IdInterviniente;
    private int porcentajePropiedad;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
    private int clienteId;
    private String apellidosNombreCliente;
    private int contratosId;
    private int tipoIntervinienteId;
    private String tipoInterviniente;
}
