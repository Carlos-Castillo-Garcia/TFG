package com.app.GestionInmuebles.DTO.Usuarios;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Usuarios Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
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
