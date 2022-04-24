package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TiposContratoRepository")
public interface TiposContratoRepository extends JpaRepository<TiposContratoEntity, Serializable> {
}
