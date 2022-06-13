package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "tipo_concepto")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoConceptoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_concepto", nullable = false)
    private int idTipoConcepto;
    @Column(name = "tipo_concepto", nullable = false)
    private String tipoConcepto;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private TipoCategoriaEntity categoriaId;

    @Column(name = "borrado")
    private boolean borrado;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "administrador_id")
    private int administradorId;
}
