package com.app.GestionInmuebles.DTO.TBIContrato;


import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbi_contratos")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TBIContratosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contrato_id", nullable = false)
    private int idContratos;
    @Column(name = "fecha_contrato", nullable = false)
    private Date fechaContrato;
    @Column(name = "valor_contrato")
    private float valorContrato;
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @Column(name = "cantidad_periodo", nullable = false)
    private int cantidadPeriodo;

    @ManyToOne
    @JoinColumn(name = "id_inmueble", nullable = false)
    private InmuebleEntity inmuebleId;

    @ManyToOne
    @JoinColumn(name = "id_tipo_periodo", nullable = false)
    private PeriodosEntity tipoPeriodoId;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contrato", nullable = false)
    private ContratosEntity tipoContratoId;


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
