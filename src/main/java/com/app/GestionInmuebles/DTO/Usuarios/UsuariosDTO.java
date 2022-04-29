package com.app.GestionInmuebles.DTO.Usuarios;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import lombok.*;

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
    private int idRol;
}
