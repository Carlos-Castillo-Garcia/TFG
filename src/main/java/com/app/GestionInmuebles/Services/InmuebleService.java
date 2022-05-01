package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface InmuebleService {
    default InmuebleEntity DTOToEntity(InmuebleDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, InmuebleEntity.class);
    }

    default InmuebleResponse EntityToResponse(InmuebleEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, InmuebleResponse.class);
    }

    List<InmuebleResponse> listarInmuebles();

    InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO);
}
