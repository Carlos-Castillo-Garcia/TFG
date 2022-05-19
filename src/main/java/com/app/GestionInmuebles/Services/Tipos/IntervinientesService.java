package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface IntervinientesService {
    default IntervinientesEntity DTOToEntity(IntervinientesDTO tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, IntervinientesEntity.class);
    }

    default IntervinientesResponse EntityToResponse(IntervinientesEntity tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, IntervinientesResponse.class);
    }

    List<IntervinientesResponse> listTipoIntervinientesadministradorId(int id);

    List<IntervinientesResponse> listTipoIntervinientesidIntervinientes(int id);

    IntervinientesResponse createUpdateTipoIntervinientes(IntervinientesDTO tipoIntervinienteDTO);
}
