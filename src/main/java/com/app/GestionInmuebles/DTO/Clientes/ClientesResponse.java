package com.app.GestionInmuebles.DTO.Clientes;

import lombok.*;

import java.util.Date;

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
    private Date fechaNacimiento;
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
