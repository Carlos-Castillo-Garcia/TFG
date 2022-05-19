package com.app.GestionInmuebles.DTO.Tipos.Roles;


import lombok.*;

import java.util.Date;

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
