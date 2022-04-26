package com.app.GestionInmuebles.DTO.TipoPeriodos;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_periodos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TipoPeriodosEntity {
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

}
