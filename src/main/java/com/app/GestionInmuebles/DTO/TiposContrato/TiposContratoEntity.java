package com.app.GestionInmuebles.DTO.TiposContrato;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipos_contrato")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TiposContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipos", nullable = false)
    private int idTipos;
    @Column(name = "tipos_contrato", nullable = false)
    private String tipoContrato;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

}
