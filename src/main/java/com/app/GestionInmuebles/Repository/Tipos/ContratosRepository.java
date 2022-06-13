package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */

@Repository("ContratosRepository")
public interface ContratosRepository extends JpaRepository<ContratosEntity, Serializable> {
    /**
     * @param idGeneral parametro necesario para la ejecucion del metodo
     * @param idEspecifico parametro necesario para la ejecucion del metodo
     * @return Contratos Entity
     */
    List<ContratosEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return Contratos Entity
     */
    List<ContratosEntity> getByidTipoContrato(int id);
}

