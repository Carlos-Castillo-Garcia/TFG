package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("IngresoGastoRepository")
public interface IngresoGastoRepository extends JpaRepository<IngresoGastoEntity, Serializable> {
    List<IngresoGastoEntity> findByInmuebleId_IdInmueble(int idInmueble);

    List<IngresoGastoEntity> findByIdInGa(int idInGa);
}
