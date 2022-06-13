package com.app.GestionInmuebles.DTO.Inmuebles;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Inmuebles Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleDTO {
    private int idInmueble;
    private String refCatastral;
    private String alias;
    private String localidad;
    private String direccion;
    private int codigoPostal;
    private int planta;
    private int nHabitaciones;
    private int mCuadrados;
    private int nBanos;
    private float latitud;
    private float longitud;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;

    private int administradorId;
    private int tipoInmueblesId;
    private int usuarioId;
}
