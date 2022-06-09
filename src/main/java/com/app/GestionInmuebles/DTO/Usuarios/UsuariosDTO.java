package com.app.GestionInmuebles.DTO.Usuarios;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDTO {
    private int idUsuario;
    private String nombre;
    private String email;
    private String password;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int rolId;
    private int entidadId;
    private int administradorId;
}
