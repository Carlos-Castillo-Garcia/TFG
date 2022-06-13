package com.app.GestionInmuebles.DTO.Tipos.Roles;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;
import java.util.List;

@ApiModel(value = "Tipos Rol Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RolesResponse {
    private int idRol;
    private String nombreRol;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}
