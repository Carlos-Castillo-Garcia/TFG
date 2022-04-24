package com.app.GestionInmuebles.DTO.Clientes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClientesDTO {
    private String localidad;
    private String direccion;
    private int codigo_postal;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private String nie;
    private String email;
    private int tlf;
    private int tlf_movil;
    private int borrado;
}
