package com.app.GestionInmuebles.DTO.Tipos.Concepos;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "tipo_especifico", nullable = false)
    private String tipoEspecifico;

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
