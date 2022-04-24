package com.app.GestionInmuebles.DTO.Inmuebles;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleResponse {
    private int idInmueble;
    private String refCatastral;
    private String alias;
    private String localidad;
    private String direccion;
    private int cp;
}
