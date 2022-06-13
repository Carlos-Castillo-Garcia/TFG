package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Tipo Concepos Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
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
