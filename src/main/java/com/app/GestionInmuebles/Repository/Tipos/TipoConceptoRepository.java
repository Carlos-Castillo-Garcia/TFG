package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("TipoConceptoRepository")
public interface TipoConceptoRepository extends JpaRepository<TipoConceptoEntity, Serializable> {
    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param idCategoria parametro necesario para la ejecucion del metodo
     * @param administradorId1 parametro necesario para la ejecucion del metodo
     * @return TipoConceptoEntity
     */
    List<TipoConceptoEntity> findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(int administradorId,int idCategoria, int administradorId1);

    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param administradorId1 parametro necesario para la ejecucion del metodo
     * @return TipoConceptoEntity
     */
    List<TipoConceptoEntity> findByAdministradorIdOrAdministradorId(int administradorId, int administradorId1);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return TipoConceptoEntity
     */
    List<TipoConceptoEntity> getByidTipoConcepto(int id);
}
