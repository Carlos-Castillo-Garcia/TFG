package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaDTO;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TipoCategoriaService {

    default TipoCategoriaEntity DTOToEntity(TipoCategoriaDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoCategoriaEntity.class);
    }

    default TipoCategoriaResponse EntityToResponse(TipoCategoriaEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoCategoriaResponse.class);
    }

    List<TipoCategoriaResponse> listarCategoriaAdministradorId(int id);

    List<TipoCategoriaResponse> listarCategoriaIdCategoria(int id);

    TipoCategoriaResponse createUpdateCategoria(TipoCategoriaDTO periodosDTO);
}
