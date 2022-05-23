package com.app.GestionInmuebles.DTO.Tipos.Pagos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagosDTO {
    private int idTipoPago;
    private String tipoPagos;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
