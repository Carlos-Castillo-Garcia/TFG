package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IntervinientesDTO {
    private int idTiposInterviniente;
    private String tipoInterviniente;

    private boolean borrado;

    private int usuarioId;
    private int administradorId;
}

