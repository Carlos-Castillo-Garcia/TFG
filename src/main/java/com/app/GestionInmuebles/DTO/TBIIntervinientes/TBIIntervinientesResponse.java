package com.app.GestionInmuebles.DTO.TBIIntervinientes;


import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
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
    private ClientesEntity idCliente;
    private TBIContratosEntity idContrato;
    private String idTipoInterviniente;
}
