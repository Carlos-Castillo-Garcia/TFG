package com.app.GestionInmuebles.DTO.Usuarios;

import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "update_time")
    private Date update_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false)
    @ToString.Exclude
    private RolesEntity rol_id;
}
