package com.app.GestionInmuebles.DTO.Clientes;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private int id_cliente;
    @Column(name = "localidad", nullable = false)
    private String localidad;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "codigo_postal", nullable = false)
    private int codigo_postal;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;
    @Column(name = "nie", nullable = false)
    private String nie;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "tlf", nullable = false)
    private int tlf;
    @Column(name = "tlf_movil", nullable = false)
    private int tlf_movil;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "update_time")
    private Date update_time;
    @Column(name = "usuario_id", nullable = false)
    private int usuario_id;
    @Column(name = "borrado", nullable = false)
    private int borrado;

    @OneToMany(mappedBy = "clienteId")
    @ToString.Exclude
    private List<TBIIntervinientesEntity> intervinientesId;

}
