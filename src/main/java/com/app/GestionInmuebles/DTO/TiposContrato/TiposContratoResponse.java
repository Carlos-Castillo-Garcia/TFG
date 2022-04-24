package com.app.GestionInmuebles.DTO.TiposContrato;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TiposContratoResponse {
    private String Tipo_contrato;
    private String Tipo_interviniente;
}
