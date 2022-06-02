package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ClientesRepository")
public interface ClientesRepository extends JpaRepository<ClientesEntity, Serializable> {
    List<ClientesEntity> findByadministradorIdAndBorradoIsFalse(int id);

    List<ClientesEntity> findByidClienteAndBorradoIsFalse(int id);

    @Query(value = "Select inmuebles.alias, intervinientes.porcentaje_propiedad " +
            " FROM gestioninmuebles.tbi_contratos as contratos" +
            " JOIN gestioninmuebles.tbi_intervinientes as intervinientes " +
            " JOIN gestioninmuebles.clientes as clientes " +
            " JOIN gestioninmuebles.inmuebles as inmuebles " +
            " WHERE intervinientes.tbi_contratos_id = contratos.contrato_id " +
            " AND intervinientes.cliente_id = clientes.id_cliente " +
            " AND inmuebles.id_inmueble = contratos.id_inmueble " +
            " AND clientes.id_cliente = ? " +
            " AND contratos.fecha_fin is null", nativeQuery = true)
    List<String> inmueblesXCliente(int idCliente);
}
