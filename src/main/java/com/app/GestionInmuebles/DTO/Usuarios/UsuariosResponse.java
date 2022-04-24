package com.app.GestionInmuebles.DTO.Usuarios;

import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UsuariosResponse {
    private String nombre;
    private String email;
    private String password;
    private String rol;
}
