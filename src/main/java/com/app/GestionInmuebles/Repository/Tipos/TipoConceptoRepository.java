package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TipoConceptoRepository")
public interface TipoConceptoRepository extends JpaRepository<TipoConceptoEntity, Serializable> {
    List<TipoConceptoEntity> findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(int administradorId,int idCategoria, int administradorId1);

    List<TipoConceptoEntity> findByAdministradorIdOrAdministradorId(int administradorId, int administradorId1);

    List<TipoConceptoEntity> getByidTipoConcepto(int id);
}
