package com.app.GestionInmuebles.DTO.TBIIntervinientes;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesDTO {
    private int idInterviniente;
    private int porcentajePropiedad;
    private int usuarioId;
    private int idCliente;
    private int idContrato;
    private int idTipoInterviniente;
}
