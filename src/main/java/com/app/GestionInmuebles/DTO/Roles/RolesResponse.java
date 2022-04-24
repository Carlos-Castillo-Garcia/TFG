package com.app.GestionInmuebles.DTO.Roles;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RolesResponse {
    private String nombreRol;
    private List<String> usuario;

}
