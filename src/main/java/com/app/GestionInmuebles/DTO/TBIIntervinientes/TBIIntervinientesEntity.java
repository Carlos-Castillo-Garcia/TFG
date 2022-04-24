package com.app.GestionInmuebles.DTO.TBIIntervinientes;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBI_Intervinientes")
public class TBIIntervinientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interviniente", nullable = false)
    private int idInterviniente;
    @Column(name = "porcentaje_propiedad", nullable = false)
    private int propiedadPorcentaje;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientesEntity clienteId;

    @ManyToOne
    @JoinColumn(name = "tbi_contratos_id", nullable = false)
    private TBIContratosEntity tbiContratosId;

    @ManyToOne
    @JoinColumn(name = "tipos_interviniente_id", nullable = false)
    private TipoIntervinienteEntity tiposIntervinientesId;
}