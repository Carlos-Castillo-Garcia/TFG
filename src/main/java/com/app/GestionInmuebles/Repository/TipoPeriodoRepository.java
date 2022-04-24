package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TipoPeriodoRepository")
public interface TipoPeriodoRepository extends JpaRepository<TipoPeriodosEntity, Serializable> {
}
