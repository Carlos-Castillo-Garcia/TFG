package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoConceptoDTO {
    private int idTipoConcepto;
    private String tipoConcepto;
    private int categoriaId;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
