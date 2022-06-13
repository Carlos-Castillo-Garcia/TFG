package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("IngresoGastoDetalleRepository")
public interface IngresoGastoDetalleRepository extends JpaRepository<IngresoGastoDetalleEntity, Serializable> {
    /**
     * @param idInGa parametro necesario para la ejecucion del metodo
     * @return IngresoGastoDetalleEntity
     */
    List<IngresoGastoDetalleEntity> findByInGaId_IdInGaAndBorradoIsFalse(int idInGa);

    /**
     * @param idInGaDetalle parametro necesario para la ejecucion del metodo
     * @return IngresoGastoDetalleEntity
     */
    List<IngresoGastoDetalleEntity> findByIdInGaDetalleAndBorradoIsFalse(int idInGaDetalle);


}
