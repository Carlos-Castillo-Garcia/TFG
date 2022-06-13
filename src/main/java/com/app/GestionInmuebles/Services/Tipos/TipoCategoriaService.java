package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaDTO;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Tipo de Categoria
 * @author Carlos Castillo
 */
public interface TipoCategoriaService {

    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaEntity
     */
    default TipoCategoriaEntity DTOToEntity(TipoCategoriaDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoCategoriaEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param i parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaResponse
     */
    default TipoCategoriaResponse EntityToResponse(TipoCategoriaEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoCategoriaResponse.class);
    }

    List<TipoCategoriaResponse> listarCategoriaAdministradorId(int id);

    List<TipoCategoriaResponse> listarCategoriaInmueble();

    List<TipoCategoriaResponse> ListarCategoriaConcepto();

    List<TipoCategoriaResponse> listarCategoriaIdCategoria(int id);

    TipoCategoriaResponse createUpdateCategoria(TipoCategoriaDTO periodosDTO);
}
