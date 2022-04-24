package com.app.GestionInmuebles.DTO.Inmuebles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InmuebleDTO {
    private int id_inmueble;
    private String ref_catastral;
    private String alias;
    private String localidad;
    private String direccion;
    private int cp;
}
