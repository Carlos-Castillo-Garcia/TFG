package com.app.GestionInmuebles.DTO.Usuarios;

import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesEntity;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolesEntity rolId;
    @Column(name = "entidad", nullable = false)
    private int entidadId;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;
    @Column(name = "id_administrador", nullable = false)
    private int administradorId;
}
