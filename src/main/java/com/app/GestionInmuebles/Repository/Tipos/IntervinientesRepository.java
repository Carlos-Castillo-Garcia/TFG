package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("IntervinientesRepository")
public interface IntervinientesRepository extends JpaRepository<IntervinientesEntity, Serializable> {
    /**
     * @param idGeneral parametro necesario para la ejecucion del metodo
     * @param idEspecifico parametro necesario para la ejecucion del metodo
     * @return IntervinientesEntity
     */
    List<IntervinientesEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return IntervinientesEntity
     */
    List<IntervinientesEntity> getByidTipoInterviniente(int id);
}

