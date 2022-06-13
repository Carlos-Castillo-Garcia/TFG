package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("ClientesRepository")
public interface ClientesRepository extends JpaRepository<ClientesEntity, Serializable> {
    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return ClientesEntity
     */
    List<ClientesEntity> findByadministradorIdAndBorradoIsFalse(int id);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return ClientesEntity
     */
    List<ClientesEntity> findByidClienteAndBorradoIsFalse(int id);

    /**
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @param tipoInterviniente parametro necesario para la ejecucion del metodo
     * @return String
     */
    @Query(value = "SELECT " +
            " inmuebles.alias, " +
            " intervinientes.porcentaje_propiedad  " +
            " FROM tbi_contratos AS contratos  " +
            " JOIN tbi_intervinientes AS intervinientes  " +
            " ON intervinientes.tbi_contratos_id = contratos.contrato_id  " +
            " JOIN clientes AS clientes  " +
            " ON intervinientes.cliente_id = clientes.id_cliente  " +
            " JOIN inmuebles AS inmuebles  " +
            " ON inmuebles.id_inmueble = contratos.id_inmueble  " +
            " JOIN tipo_interviniente AS tipointervinientes  " +
            " ON intervinientes.tipos_interviniente_id =  " +
            " tipointervinientes. tipo_interviniente_id  " +
            " WHERE clientes.id_cliente = ?  " +
            " AND tipointervinientes.tipo_interviniente_id = ?  " +
            " AND contratos.fecha_fin IS NULL  " +
            " AND intervinientes.porcentaje_propiedad >= 1", nativeQuery = true)
    List<String> inmueblesXCliente(int idCliente, int tipoInterviniente);

    /**
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @return String
     * Obtencion de la inversion total sobre todos los inmuebles filtrado por la fecha fin del contrato distinta de nula y el porcentaje de propiedad en el contrato mayor a 1
     */
    @Query(value = "SELECT sum(contratos.valor_contrato) as compra,  " +
            " sum((SELECT distinct sum(gasto.total_gasto) " +
            " FROM  ingreso_gasto as gasto " +
            " JOIN tipo_concepto as concepto " +
            " ON gasto.tipo_concepto_id = concepto.id_tipo_concepto " +
            " JOIN tipo_categoria as categoria " +
            " ON concepto.categoria_id = categoria.categoria_id " +
            " WHERE categoria.categoria_id between 5 and 6)) as inversion " +
            " FROM  tbi_contratos as contratos " +
            " JOIN  tbi_intervinientes as intervinientes " +
            " ON contratos.contrato_id = intervinientes.tbi_contratos_id " +
            " JOIN  clientes as clientes " +
            " ON intervinientes.cliente_id = clientes.id_cliente " +
            " WHERE contratos.fecha_fin is null " +
            " AND intervinientes.cliente_id = ? " +
            " AND intervinientes.porcentaje_propiedad >= 1", nativeQuery = true)
    List<String> inversion(int idCliente);

    /**
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @return ClienteEntity
     * Obtencion de los clientes filtrado por administrador y por porcentaje de propiedad mayor a 1 en el contrato
     */
    @Query(value = "SELECT DISTINCT clientes.* " +
            "FROM  tbi_contratos as contratos " +
            "JOIN  tbi_intervinientes as intervinientes " +
            " ON contratos.contrato_id = intervinientes.tbi_contratos_id" +
            "JOIN  clientes as clientes " +
            " ON intervinientes.cliente_id = clientes.id_cliente" +
            "WHERE intervinientes.porcentaje_propiedad >= 1 " +
            "AND clientes.administrador_id = ?", nativeQuery = true)
    List<ClientesEntity> clientesByInmuebles(int idAdministrador);
}
