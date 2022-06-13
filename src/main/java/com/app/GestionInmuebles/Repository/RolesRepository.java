package com.app.GestionInmuebles.Repository;


import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("RolesRepository")
public interface RolesRepository extends JpaRepository<RolesEntity, Serializable> {
    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @param especifico parametro necesario para la ejecucion del metodo
     * @return RolesEntity
     */
    List<RolesEntity> findByAdministradorIdOrAdministradorId(int id, int especifico);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return RolesEntity
     */
    List<RolesEntity> findAllByidRol(int id);
}
