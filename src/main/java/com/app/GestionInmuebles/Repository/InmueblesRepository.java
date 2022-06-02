package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("InmueblesRepository")
public interface InmueblesRepository extends JpaRepository<InmuebleEntity, Serializable> {
    List<InmuebleEntity> getByadministradorId(int id);
    List<InmuebleEntity> getByidInmueble(int id);

    @Query(value = "Select inmuebles.alias, intervinientes.porcentaje_propiedad   " +
            "FROM gestioninmuebles.tbi_contratos as contratos  " +
            "JOIN gestioninmuebles.tbi_intervinientes as intervinientes  " +
            "JOIN gestioninmuebles.clientes as clientes  " +
            "JOIN gestioninmuebles.inmuebles as inmuebles  " +
            "JOIN gestioninmuebles.tipo_interviniente as tipoIntervinientes  " +
            "WHERE intervinientes.tbi_contratos_id = contratos.contrato_id  " +
            "AND intervinientes.cliente_id = clientes.id_cliente  " +
            "AND inmuebles.id_inmueble = contratos.id_inmueble  " +
            "AND intervinientes.tipos_interviniente_id = tipoIntervinientes.tipo_interviniente_id  " +
            "AND clientes.id_cliente = ?  " +
            "AND tipoIntervinientes.tipo_interviniente_id = ?  " +
            "AND contratos.fecha_fin is null  " +
            "AND intervinientes.borrado is false", nativeQuery = true)
    List<String> propiedad(int idInmueble, int tipoInterviniente);

    @Query(value = "SELECT contratos.valor_contrato as compra,  " +
            "(SELECT distinct sum(gasto.total_gasto) " +
            "FROM gestioninmuebles.ingreso_gasto as gasto " +
            "JOIN gestioninmuebles.tipo_categoria as categoria " +
            "JOIN gestioninmuebles.tipo_concepto as concepto " +
            "WHERE gasto.tipo_concepto_id = concepto.id_tipo_concepto " +
            "AND concepto.categoria_id = categoria.categoria_id " +
            "AND categoria.categoria_id between 5 and 6) as inversion " +
            "FROM gestioninmuebles.tbi_contratos as contratos " +
            "JOIN gestioninmuebles.tbi_intervinientes as intervinientes " +
            "JOIN gestioninmuebles.clientes as clientes " +
            "WHERE contratos.contrato_id = intervinientes.tbi_contratos_id " +
            "AND intervinientes.cliente_id = clientes.id_cliente " +
            "AND contratos.fecha_fin is null " +
            "AND contratos.id_inmueble = ?", nativeQuery = true)
    List<String> inversiones(int idInmueble);
}
