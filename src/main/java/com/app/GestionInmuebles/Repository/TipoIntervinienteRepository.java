package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TipoIntervinienteRepository")
public interface TipoIntervinienteRepository extends JpaRepository<TipoIntervinienteEntity, Serializable> {
}
