package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("IngresoGastoDetalleRepository")
public interface IngresoGastoDetalleRepository extends JpaRepository<IngresoGastoDetalleEntity, Serializable> {
    List<IngresoGastoDetalleEntity> findByInGaId_IdInGaAndBorradoIsFalse(int idInGa);

    List<IngresoGastoDetalleEntity> findByIdInGaDetalleAndBorradoIsFalse(int idInGaDetalle);


}
