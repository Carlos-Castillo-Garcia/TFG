package com.app.GestionInmuebles.DTO.Tipos.Contrato;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_contrato")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ContratosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipos_contrato", nullable = false)
    private int idTipoContrato;
    @Column(name = "tipos_contrato", nullable = false)
    private String tipoContrato;

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
