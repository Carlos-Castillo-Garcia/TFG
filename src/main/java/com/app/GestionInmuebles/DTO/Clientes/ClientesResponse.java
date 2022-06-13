package com.app.GestionInmuebles.DTO.Clientes;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Clientes Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientesResponse {
    private int idCliente;
    private String localidad;
    private String direccion;
    private int codigoPostal;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nie;
    private String email;
    private int tlf;
    private int tlfMovil;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}
