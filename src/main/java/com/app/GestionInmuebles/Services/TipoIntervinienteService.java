package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteDTO;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteEntity;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TipoIntervinienteService {
    default TipoIntervinienteEntity DTOToEntity(TipoIntervinienteDTO tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, TipoIntervinienteEntity.class);
    }

    default TipoIntervinienteResponse EntityToResponse(TipoIntervinienteEntity tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, TipoIntervinienteResponse.class);
    }

    List<TipoIntervinienteResponse> listTipoInterviniente();

    TipoIntervinienteResponse createUpdateTipoInterviniente(TipoIntervinienteDTO tipoIntervinienteDTO);
}
