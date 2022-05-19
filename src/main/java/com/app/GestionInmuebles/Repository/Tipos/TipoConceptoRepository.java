package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TipoConceptoRepository")
public interface TipoConceptoRepository extends JpaRepository<TipoConceptoEntity, Serializable> {
    List<TipoConceptoEntity> getByadministradorId(int id);

    List<TipoConceptoEntity> getByidTipoConcepto(int id);
}
