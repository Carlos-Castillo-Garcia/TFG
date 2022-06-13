package com.app.GestionInmuebles.DTO.Inmuebles;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel(value = "Inmuebles Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
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
//    private float latitud;
//    private float longitud;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
    private int tipoCategoriaId;
    private String tipoCategoria;
    private int tipoInmueblesId;
    private String tipoInmueble;
}
