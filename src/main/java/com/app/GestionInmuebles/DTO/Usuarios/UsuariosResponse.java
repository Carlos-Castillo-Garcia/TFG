package com.app.GestionInmuebles.DTO.Usuarios;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosResponse {
    private int inmuebleId;
    private String nombre;
    private String email;
    private String password;
    private String rol;
}
