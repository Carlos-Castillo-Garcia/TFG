package com.app.GestionInmuebles.DTO.Tipos.Inmuebles;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoInmuebleDTO {
    private int idTipoInmueble;
    private String tipoInmueble;
    private int categoriaId;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
