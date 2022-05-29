package com.app.GestionInmuebles.DTO.Inmuebles;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "planta")
    private int planta;
    @Column(name = "n_habitaciones")
    private int nHabitaciones;
    @Column(name = "m_cuadrados")
    private int mCuadrados;
    @Column(name = "n_banos")
    private int nBanos;

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

    @ManyToOne
    @JoinColumn(name = "tipo_categoria_id", nullable = false)
    private TipoInmuebleEntity idTipoInmueble;

}
