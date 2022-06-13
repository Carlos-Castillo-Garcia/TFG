package com.app.GestionInmuebles.DTO.Tipos.Categoria;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "tipo_categoria")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TipoCategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private int idCategoria;
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "administrador_id", nullable = false)
    private int administradorId;
}
