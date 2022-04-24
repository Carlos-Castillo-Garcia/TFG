package com.app.GestionInmuebles.DTO.TBIContrato;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbi_contratos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TBIContratosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contrato_id", nullable = false)
    private int contratoId;
    @Column(name = "fecha_contrato", nullable = false)
    private Date fechaContrato;
    @Column(name = "valor_contrato", nullable = false)
    private float valorContrato;
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;
    @Column(name = "cantidad_periodo", nullable = false)
    private int cantidadPeriodo;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "borrado")
    private int borrado;

    @ManyToOne
    @JoinColumn(name = "inmuebles_id", nullable = false)
    private InmuebleEntity inmuebleId;

    @ManyToOne
    @JoinColumn(name = "tipo_periodos_id", nullable = false)
    private TipoPeriodosEntity tipoPeriodosId;

    @ManyToOne
    @JoinColumn(name = "tipos_contrato_id", nullable = false)
    private TiposContratoEntity tiposContratoEntity;

}
