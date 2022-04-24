package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TBIContratosService {
    default TBIContratosEntity DTOToEntity(TBIContratosDTO inmueble){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, TBIContratosEntity.class);
    }

    default TBIContratosResponse EntityToResponse(TBIContratosEntity inmueble){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, TBIContratosResponse.class);
    }

    List<TBIContratosResponse> listarContratos();

    TBIContratosResponse CrearContratos(TBIContratosDTO tbiContratosDTO);
}
