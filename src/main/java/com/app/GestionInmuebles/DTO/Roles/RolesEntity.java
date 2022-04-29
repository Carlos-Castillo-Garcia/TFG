package com.app.GestionInmuebles.DTO.Roles;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private int idRol;
    @Column(name = "nombre_rol")
    private String nombreRol;
    @Column(name = "borrado", columnDefinition = "0")
    private int borrado;

    @OneToMany(mappedBy = "rolId")
    @ToString.Exclude
    private List<UsuariosEntity> usuario;

}
