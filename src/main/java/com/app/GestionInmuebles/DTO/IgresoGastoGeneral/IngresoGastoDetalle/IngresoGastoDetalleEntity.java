package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso_gasto_detalle")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresoGastoDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_in_ga_detalle", nullable = false)
    private int idInGaDetalle;
    @Column(name = "concepto_detalle", nullable = false)
    private String conceptoDetalle;
    @Column(name = "pv", nullable = false)
    private float pv;
    @Column(name = "descuento", nullable = false)
    private float descuento;
    @Column(name = "iva_Porcentaje", nullable = false)
    private float ivaPorcentaje;
    @Column(name = "cantidad", nullable = false)
    private float cantidad;

    @ManyToOne
    @JoinColumn(name = "ingreso_gasto_id", nullable = false)
    private IngresoGastoEntity inGaId;

    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
    @Column(name = "borrado", nullable = false)
    private boolean borrado;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "administrador_id", nullable = false)
    private int administradorId;
}
