package com.app.GestionInmuebles.DTO.TiposContrato;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipos_contrato")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TiposContratoEntity {
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
    private int borrado;
}
