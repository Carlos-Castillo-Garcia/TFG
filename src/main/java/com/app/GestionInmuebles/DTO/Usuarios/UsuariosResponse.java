package com.app.GestionInmuebles.DTO.Usuarios;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosResponse {
    private int idUsuario;
    private String nombre;
    private String email;
    private String password;
    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int rolId;
    private String nombreRol;
    private int administradorId;
}
