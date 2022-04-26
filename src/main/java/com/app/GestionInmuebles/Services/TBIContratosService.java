package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TBIContratosService {
    default TBIContratosEntity DTOToEntity(TBIContratosDTO contratos){
        ModelMapper modelMapper = new ModelMapper();
        TBIContratosEntity contrato = modelMapper.map(contratos, TBIContratosEntity.class);
        return contrato;
    }

    default TBIContratosResponse EntityToResponse(TBIContratosEntity contratos){
        ModelMapper modelMapper = new ModelMapper();
        TBIContratosResponse contrato = modelMapper.map(contratos, TBIContratosResponse.class);
        return contrato;
    }

    List<TBIContratosResponse> listarContratos();

    TBIContratosResponse CrearContratos(TBIContratosDTO tbiContratosDTO);
}
