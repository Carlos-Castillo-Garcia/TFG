package com.app.GestionInmuebles.DTO.Tipos.Intervinientes;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "tipo_interviniente")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class IntervinientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_interviniente_id", nullable = false)
    private int idTipoInterviniente;
    @Column(name = "tipo_interviniente")
    private String tipoInterviniente;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;

    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "administrador_id")
    private int administradorId;

}
