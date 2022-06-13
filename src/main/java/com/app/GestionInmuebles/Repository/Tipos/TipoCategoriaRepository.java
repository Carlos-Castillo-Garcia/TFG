package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("TipoCategoriaRepository")
public interface TipoCategoriaRepository extends JpaRepository<TipoCategoriaEntity, Serializable> {

    /**
     * @param idGeneral parametro necesario para la ejecucion del metodo
     * @param idEspecifico parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaEntity
     */
    List<TipoCategoriaEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    /**
     * @param idCategoriaStart parametro necesario para la ejecucion del metodo
     * @param idCategoriaEnd parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaEntity
     */
    @Query("select t from TipoCategoriaEntity t where t.idCategoria between ?1 and ?2")
    List<TipoCategoriaEntity> categoriaConcepto(int idCategoriaStart, int idCategoriaEnd);

    /**
     * @param idCategoriaStart parametro necesario para la ejecucion del metodo
     * @param idCategoriaEnd parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaEntity
     */
    @Query("select t from TipoCategoriaEntity t where t.idCategoria between ?1 and ?2")
    List<TipoCategoriaEntity> categoriaInmueble(int idCategoriaStart, int idCategoriaEnd);

    /**
     * @param idCategoria parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaEntity
     */
    List<TipoCategoriaEntity> findByIdCategoria(int idCategoria);

}
