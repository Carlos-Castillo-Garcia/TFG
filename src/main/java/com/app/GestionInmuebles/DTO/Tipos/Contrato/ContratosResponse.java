package com.app.GestionInmuebles.DTO.Tipos.Contrato;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ContratosResponse {
    private int idTipoContrato;
    private String tipoContrato;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}