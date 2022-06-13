package com.app.GestionInmuebles.DTO.TBIIntervinientes;


import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.Date;

@ApiModel(value = "Intervinientes Response", description = "Objeto para la transferencia de datos de la parte Back a la parte Front con la respuesta de las peticiones a Base de datos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TBIIntervinientesResponse {
    private int IdInterviniente;
    private int porcentajePropiedad;

    private Date createTime;
    private Date updateTime;
    private boolean borrado;

    private int usuarioId;
    private int administradorId;
    private int clienteId;
    private String apellidosNombreCliente;
    private int contratosId;
    private int tipoIntervinienteId;
    private String tipoInterviniente;
}
