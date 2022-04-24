package com.app.GestionInmuebles.DTO.Usuarios;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UsuariosDTO {
    private String nombre;
    private String email;
    private String password;
    private RolesDTO rol;
}
