package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TBIIntervinientesService {
    default TBIIntervinientesEntity DTOToEntity(TBIIntervinientesDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        TBIIntervinientesEntity intervinientesEntity =
                modelMapper.map(inmueble, TBIIntervinientesEntity.class);
        return intervinientesEntity;
    }

    default TBIIntervinientesResponse EntityToResponse(TBIIntervinientesEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        TBIIntervinientesResponse intervinientesResponse =
                modelMapper.map(inmueble, TBIIntervinientesResponse.class);
        return intervinientesResponse;
    }

    List<TBIIntervinientesResponse> listar_Inmuebles();

    TBIIntervinientesResponse CrearInmuebles(TBIIntervinientesDTO intervinientesDTO);
}
