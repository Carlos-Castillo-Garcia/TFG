package com.app.GestionInmuebles.DTO.Tipos.Periodos;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "tipo_periodos")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PeriodosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipos_periodos", nullable = false)
    private int idTipoPeriodo;
    @Column(name = "tipo_periodo", nullable = false)
    private String tipoPeriodo;

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