package com.app.GestionInmuebles.DTO.Tipos.Pagos;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "tipo_pagos")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagos", nullable = false)
    private int idTipoPago;
    @Column(name = "tipo_pago", nullable = false)
    private String tipoPagos;

    @Column(name = "borrado", nullable = false)
    private boolean borrado;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Column(name = "update_time", nullable = false)
    private Date updateTime;


    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "administrador_id", nullable = false)
    private int administradorId;
}
