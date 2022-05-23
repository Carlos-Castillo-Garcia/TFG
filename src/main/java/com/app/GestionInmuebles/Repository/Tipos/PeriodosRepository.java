package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("PeriodosRepository")
public interface PeriodosRepository extends JpaRepository<PeriodosEntity, Serializable> {
    List<PeriodosEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    List<PeriodosEntity> getByidTipoPeriodo(int id);
}