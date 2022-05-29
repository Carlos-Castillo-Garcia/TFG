package com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
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
    private int idInGa;
    @Column(name = "fecha_factura", nullable = false)
    private Date fechaFactura;
    @Column(name = "fecha_pago")
    private Date fechaPago;
    @Column(name = "numero_factura", nullable = false)
    private String numeroFactura;
    @Column(name = "t_base_imponible", nullable = false)
    private float totalBaseImponible;
    @Column(name = "t_imp_iva", nullable = false)
    private float totalImpuestoIva;
    @Column(name = "total_gasto", nullable = false)
    private float totalGasto;
    @Column(name = "total_ingreso", nullable = false)
    private float totalIngreso;
    @Column(name = "cuenta_corrient_proveedor")
    private String cuentaCorrienteProveedor;
    @Column(name = "cuenta_corriente_cliente")
    private String cuentaCorrienteCliente;

    @ManyToOne
    @JoinColumn(name = "tipo_concepto_id", nullable = false)
    private TipoConceptoEntity tipoConceptoId;
    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", nullable = false)
    private PagosEntity tipoPagoId;
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
