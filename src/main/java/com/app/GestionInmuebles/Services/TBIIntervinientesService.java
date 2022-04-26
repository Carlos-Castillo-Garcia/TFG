package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TBIIntervinientesService {
    default TBIIntervinientesEntity DTOToEntity(TBIIntervinientesDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        TBIIntervinientesEntity tbiIntervinientesEntity = modelMapper.map(inmueble, TBIIntervinientesEntity.class);
        return tbiIntervinientesEntity;
    }

    default TBIIntervinientesResponse EntityToResponse(TBIIntervinientesEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        TBIIntervinientesResponse tbiIntervinientesResponse = modelMapper.map(inmueble, TBIIntervinientesResponse.class);
        return tbiIntervinientesResponse;
    }

    List<TBIIntervinientesResponse> listarIntervinientes();

    TBIIntervinientesResponse CrearIntervinientes(TBIIntervinientesDTO intervinientesDTO);
}
