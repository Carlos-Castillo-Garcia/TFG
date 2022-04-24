package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TBIContratosService {
    default TBIContratosEntity DTOToEntity(TBIContratosDTO inmueble){
        ModelMapper modelMapper = new ModelMapper();
        TBIContratosEntity contratosEntity = modelMapper.map(inmueble, TBIContratosEntity.class);
        return contratosEntity;
    }

    default TBIContratosResponse EntityToResponse(TBIContratosEntity inmueble){
        ModelMapper modelMapper = new ModelMapper();
        TBIContratosResponse contratosResponse = modelMapper.map(inmueble, TBIContratosResponse.class);
        return contratosResponse;
    }

    List<TBIContratosResponse> listar_Inmuebles();

    void CrearInmuebles();
}
