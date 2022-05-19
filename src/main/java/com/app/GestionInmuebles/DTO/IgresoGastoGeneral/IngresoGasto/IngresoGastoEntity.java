package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso_gasto")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresoGastoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso_gasto", nullable = false)
    private Long idInGa;
    @Column(name = "fecha_concepto", nullable = false)
    private Date fechaConcepto;
    @Column(name = "concepto", nullable = false)
    private String concepto;
    @Column(name = "ingreso", nullable = false)
    private float ingreso;
    @Column(name = "iva_porcentaje", nullable = false)
    private int ivaPorcentaje;
    @Column(name = "gasto", nullable = false)
    private float gasto;
    @Column(name = "fecha_factura", nullable = false)
    private Date fechaFactura;
    @Column(name = "numero_factura", nullable = false)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "tipo_concepto_id", nullable = false)
    private TipoConceptoEntity tipoConceptoId;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientesEntity clienteId;
    @ManyToOne
    @JoinColumn(name = "inmueble_id", nullable = false)
    private InmuebleEntity inmuebleId;

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
