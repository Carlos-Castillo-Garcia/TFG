package com.app.GestionInmuebles.DTO.Inmuebles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InmuebleResponse {
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

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
    private int tipoInmueblesId;
}
