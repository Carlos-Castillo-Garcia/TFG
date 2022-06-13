package com.app.GestionInmuebles.DTO.Tipos.Roles;


import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Roles Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolesDTO {
    private int idRol;
    private String nombreRol;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int usuarioId;
    private int administradorId;
}
