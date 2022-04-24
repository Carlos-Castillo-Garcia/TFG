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
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nombre_rol")
    private String nombre_rol;

    @OneToMany(mappedBy = "rol_id")
    @ToString.Exclude
    private List<UsuariosEntity> usuario;

}
