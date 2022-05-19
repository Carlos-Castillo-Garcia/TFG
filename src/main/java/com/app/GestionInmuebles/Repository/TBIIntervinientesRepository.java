package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository("TBIIntervinientesRepository")
public interface TBIIntervinientesRepository extends JpaRepository<TBIIntervinientesEntity, Serializable> {
    @Query("select t from TBIIntervinientesEntity t where t.contratosId.idContratos = ?1")
    List<TBIIntervinientesEntity> getByContratosId(int idContratos);
    List<TBIIntervinientesEntity> getByidInterviniente(int id);
}
