package com.app.GestionInmuebles.DTO.Inmuebles;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import lombok.*;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inmuebles")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InmuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inmueble", nullable = false)
    private int id_inmueble;
    @Column(name = "ref_catastral", nullable = false)
    private String ref_catastral;
    @Column(name = "alias", nullable = false)
    private String alias;
    @Column(name = "localidad", nullable = false)
    private String localidad;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "codigo_postal", nullable = false)
    private int codigo_postal;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "update_time")
    private Date update_time;
    @Column(name = "usuario_id", nullable = false)
    private int usuario_id;
    @Column(name = "borrado", nullable = false)
    private int borrado;

    @OneToMany(mappedBy = "inmuebleId")
    @ToString.Exclude
    private List<TBIContratosEntity> contratosId;

}
