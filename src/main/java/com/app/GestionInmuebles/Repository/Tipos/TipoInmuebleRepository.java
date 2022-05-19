package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TipoInmuebleRepository")
public interface TipoInmuebleRepository extends JpaRepository<TipoInmuebleEntity, Serializable> {
    List<TipoInmuebleEntity> getByadministradorId(int id);

    List<TipoInmuebleEntity> getByidTipoInmueble(int id);
}
