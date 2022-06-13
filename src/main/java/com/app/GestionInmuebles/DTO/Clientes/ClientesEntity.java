package com.app.GestionInmuebles.DTO.Clientes;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "clientes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Column(name = "localidad", nullable = false)
    private String localidad;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "codigo_postal", nullable = false)
    private int codigoPostal;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "nie", nullable = false, unique = true)
    private String nie;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "tlf")
    private int tlf;
    @Column(name = "tlf_movil", nullable = false)
    private int tlfMovil;


    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado", nullable = false)
    private boolean borrado;


    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "id_administrador", nullable = false)
    private int administradorId;

}
