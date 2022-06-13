package com.app.GestionInmuebles.DTO.Usuarios;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Usuarios Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
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
    private int entidadId;
    private int administradorId;
}
