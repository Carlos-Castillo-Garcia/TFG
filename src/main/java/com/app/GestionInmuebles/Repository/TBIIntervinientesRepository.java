package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TBIIntervinientesRepository")
public interface TBIIntervinientesRepository extends JpaRepository<TBIIntervinientesEntity, Serializable> {
}
