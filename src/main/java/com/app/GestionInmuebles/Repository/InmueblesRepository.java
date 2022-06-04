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

    @Query(value = "SELECT  " +
            "  inmuebles.alias, " +
            "  intervinientes.porcentaje_propiedad " +
            " FROM " +
            " tbi_contratos AS contratos " +
            " JOIN tbi_intervinientes AS intervinientes " +
            " ON intervinientes.tbi_contratos_id = contratos.contrato_id " +
            " JOIN clientes AS clientes " +
            " ON intervinientes.cliente_id = clientes.id_cliente " +
            " JOIN inmuebles AS inmuebles " +
            " ON inmuebles.id_inmueble = contratos.id_inmueble " +
            " JOIN tipo_interviniente AS tipointervinientes " +
            " ON intervinientes.tipos_interviniente_id = " +
            " tipointervinientes. tipo_interviniente_id " +
            " WHERE clientes.id_cliente = ?   " +
            " AND tipointervinientes.tipo_interviniente_id = ?   " +
            " AND contratos.fecha_fin IS NULL   " +
            " AND intervinientes.porcentaje_propiedad >= 1", nativeQuery = true)
    List<String> propiedad(int idInmueble, int tipoInterviniente);

    @Query(value = "SELECT sum(contratos.valor_contrato) as compra,   " +
            " sum((SELECT distinct sum(gasto.total_gasto)  " +
            " FROM gestioninmuebles.ingreso_gasto as gasto  " +
            " JOIN gestioninmuebles.tipo_concepto as concepto  " +
            " ON gasto.tipo_concepto_id = concepto.id_tipo_concepto  " +
            " JOIN gestioninmuebles.tipo_categoria as categoria  " +
            " ON concepto.categoria_id = categoria.categoria_id  " +
            " WHERE categoria.categoria_id between 5 and 6)) as inversion  " +
            " FROM gestioninmuebles.tbi_contratos as contratos  " +
            " JOIN gestioninmuebles.tbi_intervinientes as intervinientes  " +
            " ON contratos.contrato_id = intervinientes.tbi_contratos_id  " +
            " JOIN gestioninmuebles.clientes as clientes  " +
            " ON intervinientes.cliente_id = clientes.id_cliente  " +
            " WHERE contratos.fecha_fin is null  " +
            " AND intervinientes.cliente_id = ?  " +
            " AND intervinientes.porcentaje_propiedad >= 1", nativeQuery = true)
    List<String> inversiones(int idInmueble);
}
