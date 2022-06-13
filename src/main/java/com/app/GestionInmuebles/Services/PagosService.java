package com.app.GestionInmuebles.Services;


import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Pagos
 * @author Carlos Castillo
 */
public interface PagosService {

    /**
     * Mapper de DTO a Entity
     * @param pagosDTO parametro necesario para la ejecucion del metodo
     * @return PagosEntity
     */
    default PagosEntity DTOToEntity(PagosDTO pagosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pagosDTO, PagosEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param pagosEntity parametro necesario para la ejecucion del metodo
     * @return PagosResponse
     */
    default PagosResponse EntityToResponse(PagosEntity pagosEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pagosEntity, PagosResponse.class);
    }

    List<PagosResponse> listarPagosIdAdministrador(int id);

    List<PagosResponse> listarPagosIdPagos(int id);

    PagosResponse createUpdatePagos(PagosDTO dto);

}
