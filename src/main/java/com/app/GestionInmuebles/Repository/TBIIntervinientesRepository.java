package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("TBIIntervinientesRepository")
public interface TBIIntervinientesRepository extends JpaRepository<TBIIntervinientesEntity, Serializable> {
    /**
     * @param idContratos parametro necesario para la ejecucion del metodo
     * @return TBIIntervinientesEntity
     */
    @Query("select t from TBIIntervinientesEntity t where t.contratosId.idContratos = ?1")
    List<TBIIntervinientesEntity> getByContratosId(int idContratos);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return TBIIntervinientesEntity
     */
    List<TBIIntervinientesEntity> getByidInterviniente(int id);
}
