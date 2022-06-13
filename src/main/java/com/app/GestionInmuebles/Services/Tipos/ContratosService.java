package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Tipos de Contratos
 * @author Carlos Castillo
 */
public interface ContratosService {
    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return ContratosEntity
     */
    default ContratosEntity DTOToEntity(ContratosDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ContratosEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param i parametro necesario para la ejecucion del metodo
     * @return ContratosResponse
     */
    default ContratosResponse EntityToResponse(ContratosEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ContratosResponse.class);
    }

    List<ContratosResponse> listarTiposContratoadministradorId(int id);

    List<ContratosResponse> listarTiposContratoidContrato(int id);

    ContratosResponse createUpdateTiposContrato(ContratosDTO ContratoDTO);
}
