package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface InmuebleService {
    default InmuebleEntity DTOToEntity(InmuebleDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        InmuebleEntity inmuebleEntity = modelMapper.map(inmueble, InmuebleEntity.class);
        return inmuebleEntity;
    }

    default InmuebleResponse EntityToResponse(InmuebleEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        InmuebleResponse inmuebleResponse = modelMapper.map(inmueble, InmuebleResponse.class);
        return inmuebleResponse;
    }

    List<InmuebleResponse> listarInmuebles();

    InmuebleResponse CrearInmuebles(InmuebleDTO inmuebleDTO);
}
