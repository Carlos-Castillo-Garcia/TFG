package com.app.GestionInmuebles.DTO.PersonasPagadoras;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Personas Pagadoras Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
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
