package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface ContratosService {
    default ContratosEntity DTOToEntity(ContratosDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ContratosEntity.class);
    }

    default ContratosResponse EntityToResponse(ContratosEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ContratosResponse.class);
    }

    List<ContratosResponse> listarTiposContratoadministradorId(int id);

    List<ContratosResponse> listarTiposContratoidContrato(int id);

    ContratosResponse createUpdateTiposContrato(ContratosDTO ContratoDTO);
}
