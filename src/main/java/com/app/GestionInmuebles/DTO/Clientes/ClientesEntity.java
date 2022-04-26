package com.app.GestionInmuebles.DTO.Clientes;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "nie", nullable = false)
    private String nie;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "tlf", nullable = false)
    private int tlf;
    @Column(name = "tlf_movil", nullable = false)
    private int tlfMovil;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "borrado", nullable = false)
    private int borrado;

}
