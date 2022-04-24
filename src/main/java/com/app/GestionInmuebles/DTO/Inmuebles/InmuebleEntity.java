package com.app.GestionInmuebles.DTO.Inmuebles;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inmuebles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inmueble", nullable = false)
    private int idInmueble;
    @Column(name = "ref_catastral", nullable = false)
    private String refCatastral;
    @Column(name = "alias", nullable = false)
    private String alias;
    @Column(name = "localidad", nullable = false)
    private String localidad;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "codigo_postal", nullable = false)
    private int codigoPostal;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "borrado", nullable = false)
    private int borrado;

    @OneToMany(mappedBy = "inmuebleId")
    @ToString.Exclude
    private List<TBIContratosEntity> contratosId;

}
