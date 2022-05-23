package com.app.GestionInmuebles.DTO.Tipos.Contrato;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratosDTO {
    private int idTipoContrato;
    private String tipoContrato;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}