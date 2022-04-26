package com.app.GestionInmuebles.DTO.TipoInterviniente;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_interviniente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoIntervinienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_interviniente_id", nullable = false)
    private int idTipoInterviniente;
    @Column(name = "tipo_interviniente")
    private String tipoInterviniente;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

}
