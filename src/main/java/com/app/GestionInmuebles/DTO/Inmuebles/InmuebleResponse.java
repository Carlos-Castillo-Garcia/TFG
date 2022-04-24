package com.app.GestionInmuebles.DTO.Inmuebles;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InmuebleResponse {
    private int id_inmueble;
    private String ref_catastral;
    private String alias;
    private String localidad;
    private String direccion;
    private int cp;
}
