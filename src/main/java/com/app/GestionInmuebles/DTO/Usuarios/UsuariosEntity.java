package com.app.GestionInmuebles.DTO.Usuarios;

import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private int borrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false)
    @ToString.Exclude
    private RolesEntity idRol;
}
