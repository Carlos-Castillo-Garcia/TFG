package com.app.GestionInmuebles.DTO.PersonasPagadoras;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonasPagadorasDTO {
    private int idPersonasPagadora;
    private String nombre;
    private String apellidos;
    private String email;
    private String nie;
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private Date fechaNacimiento;
    private int tlf;
    private int tlfMovil;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;
}
