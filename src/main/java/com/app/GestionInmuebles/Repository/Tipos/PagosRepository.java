package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("PagosRepository")
public interface PagosRepository extends JpaRepository<PagosEntity, Serializable> {
    /**
     * @param idGeneral parametro necesario para la ejecucion del metodo
     * @param idEspecifico parametro necesario para la ejecucion del metodo
     * @return PagosEntity
     */
    List<PagosEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    /**
     * @param idPagos parametro necesario para la ejecucion del metodo
     * @return PagosEntity
     */
    List<PagosEntity> findByIdTipoPago(int idPagos);

}
