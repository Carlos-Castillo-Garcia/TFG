package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TBIContratosRepository")
public interface TBIContratosRepository extends JpaRepository<TBIContratosEntity, Serializable> {
    List<TBIContratosEntity> getByadministradorIdOrderByInmuebleId_AliasAsc(int id);

    @Query(value = "SELECT * \n" +
            "FROM tbi_contratos as contratos\n" +
            "JOIN tbi_intervinientes as intervinientes\n" +
            "ON intervinientes.tbi_contratos_id = contratos.contrato_id\n" +
            "JOIN clientes as clientes\n" +
            "ON clientes.id_cliente = intervinientes.cliente_id\n" +
            "JOIN usuarios as user \n" +
            "ON clientes.id_cliente = user.entidad\n" +
            "JOIN inmuebles as inmuebles\n" +
            "ON contratos.id_inmueble = inmuebles.id_inmueble\n" +
            "WHERE contratos.administrador_id = ?\n" +
            "AND user.entidad = ?\n" +
            "ORDER BY inmuebles.alias DESC", nativeQuery = true)
    List<TBIContratosEntity> getByEntidadOrderByInmuebleId_AliasAsc(int administradorId, int propietario);

    List<TBIContratosEntity> getByidContratos(int id);
}
