package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("IntervinientesRepository")
public interface IntervinientesRepository extends JpaRepository<IntervinientesEntity, Serializable> {
    List<IntervinientesEntity> getByadministradorId(int id);

    List<IntervinientesEntity> getByidTipoInterviniente(int id);
}

