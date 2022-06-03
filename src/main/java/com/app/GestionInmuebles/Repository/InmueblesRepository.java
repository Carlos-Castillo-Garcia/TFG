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

    @Query(value = "SELECT\n" +
            "\tinmuebles.alias,\n" +
            "\tintervinientes.porcentaje_propiedad \n" +
            "FROM\n" +
            "\ttbi_contratos AS contratos \n" +
            "\t\tJOIN tbi_intervinientes AS intervinientes \n" +
            "\t\tON intervinientes.tbi_contratos_id = contratos.contrato_id \n" +
            "\t\t\tJOIN clientes AS clientes \n" +
            "\t\t\tON intervinientes.cliente_id = clientes.id_cliente \n" +
            "\t\t\t\tJOIN inmuebles AS inmuebles \n" +
            "\t\t\t\tON inmuebles.id_inmueble = contratos.id_inmueble \n" +
            "\t\t\t\t\tJOIN tipo_interviniente AS tipointervinientes \n" +
            "\t\t\t\t\tON intervinientes.tipos_interviniente_id = \n" +
            "\t\t\t\t\ttipointervinientes. tipo_interviniente_id \n" +
            "WHERE\n" +
            "\tclientes.id_cliente = ? \n" +
            "\tAND tipointervinientes.tipo_interviniente_id = ? \n" +
            "\tAND contratos.fecha_fin IS NULL \n" +
            "\tAND intervinientes.porcentaje_propiedad >= 1", nativeQuery = true)
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
