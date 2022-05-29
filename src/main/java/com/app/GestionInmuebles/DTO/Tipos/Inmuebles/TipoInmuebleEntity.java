package com.app.GestionInmuebles.DTO.Tipos.Inmuebles;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_inmuebles")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TipoInmuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_inmueble", nullable = false)
    private int idTipoInmueble;
    @Column(name = "tipoinmueble", nullable = false)
    private String tipoInmueble;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private TipoCategoriaEntity categoriaId;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "borrado")
    private boolean borrado;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "administrador_id")
    private int administradorId;
}
