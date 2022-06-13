package com.app.GestionInmuebles.DTO.TBIIntervinientes;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import io.swagger.annotations.ApiModel;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Objeto para el tratado de datos con la Base de datos
 * @author Carlos Castillo
  */
@Entity
@Table(name = "TBI_Intervinientes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TBIIntervinientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interviniente", nullable = false)
    private int idInterviniente;
    @Column(name = "porcentaje_propiedad", nullable = false)
    private int porcentajePropiedad;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientesEntity clienteId;

    @ManyToOne
    @JoinColumn(name = "tbi_contratos_id", nullable = false)
    private TBIContratosEntity contratosId;

    @ManyToOne
    @JoinColumn(name = "tipos_interviniente_id", nullable = false)
    private IntervinientesEntity tipoIntervinienteId;


    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Column(name = "administrador_id", nullable = false)
    private int administradorId;


}
