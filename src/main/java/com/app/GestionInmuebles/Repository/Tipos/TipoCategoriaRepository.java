package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TipoCategoriaRepository")
public interface TipoCategoriaRepository extends JpaRepository<TipoCategoriaEntity, Serializable> {

    List<TipoCategoriaEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    List<TipoCategoriaEntity> findByIdCategoria(int idCategoria);

}
