package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TipoCategoriaRepository")
public interface TipoCategoriaRepository extends JpaRepository<TipoCategoriaEntity, Serializable> {

    List<TipoCategoriaEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    @Query("select t from TipoCategoriaEntity t where t.idCategoria between ?1 and ?2")
    List<TipoCategoriaEntity> categoriaConcepto(int idCategoriaStart, int idCategoriaEnd);

    @Query("select t from TipoCategoriaEntity t where t.idCategoria between ?1 and ?2")
    List<TipoCategoriaEntity> categoriaInmueble(int idCategoriaStart, int idCategoriaEnd);

    List<TipoCategoriaEntity> findByIdCategoria(int idCategoria);

}
