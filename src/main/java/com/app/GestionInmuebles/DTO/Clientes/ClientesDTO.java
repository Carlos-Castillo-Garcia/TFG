package com.app.GestionInmuebles.DTO.Clientes;

//import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.annotations.ApiModel;
import lombok.*;
import java.util.Date;

@ApiModel(value = "Clientes Data Transfer Object", description = "Objeto para la transferencia de datos de la parte Front a la parte Back")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {
    private int idCliente;
    private String localidad;
    private String direccion;
    private int codigoPostal;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String nie;
    private String email;
    private int tlf;
    private int tlfMovil;

    private boolean borrado;
    private Date createTime;
    private Date updateTime;
    private int usuarioId;
    private int administradorId;
}
