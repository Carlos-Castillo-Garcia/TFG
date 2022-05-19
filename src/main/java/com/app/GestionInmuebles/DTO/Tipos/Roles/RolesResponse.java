package com.app.GestionInmuebles.DTO.Tipos.Roles;

import lombok.*;

import java.util.Date;
import java.util.List;

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
