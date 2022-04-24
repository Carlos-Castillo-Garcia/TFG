package com.app.GestionInmuebles.DTO.TiposContrato;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tipos_contrato")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TiposContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipos", nullable = false)
    private int id_tipos;
    @Column(name = "tipos_contrato", nullable = false)
    private String tipos_contrato;
    @Column(name = "tipos_interviniente", nullable = false)
    private String tipos_interviniente;

}
