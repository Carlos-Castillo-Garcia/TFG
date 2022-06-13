package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("TipoInmuebleRepository")
public interface TipoInmuebleRepository extends JpaRepository<TipoInmuebleEntity, Serializable> {
    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param idCategoria parametro necesario para la ejecucion del metodo
     * @param administradorId1 parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleEntity
     */
    List<TipoInmuebleEntity> findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(int administradorId, int idCategoria, int administradorId1);

    /**
     * @param idGeneral parametro necesario para la ejecucion del metodo
     * @param idEspecifico parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleEntity
     */
    List<TipoInmuebleEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleEntity
     */
    List<TipoInmuebleEntity> getByidTipoInmueble(int id);

}
