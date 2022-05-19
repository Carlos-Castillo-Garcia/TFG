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
    private Long idInGaDetalle;
    @Column(name = "concepto_detalle", nullable = false)
    private String conceptoDetalle;
    @Column(name = "ingreso", nullable = false)
    private float ingreso;
    @Column(name = "gasto", nullable = false)
    private float gasto;
    @Column(name = "iva_Porcentaje", nullable = false)
    private int ivaPorcentaje;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

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
