package com.app.GestionInmuebles.DTO.PersonasPagadoras;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas_pagadoras")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonasPagadorasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personas_pagadoras", nullable = false)
    private int idPersonasPagadora;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "nie", nullable = false, unique = true)
    private String nie;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "localidad", nullable = false)
    private String localidad;
    @Column(name = "codigo_postal", nullable = false)
    private int codigoPostal;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "tlf")
    private int tlf;
    @Column(name = "tlf_movil", nullable = false)
    private int tlfMovil;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;
}
