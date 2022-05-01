package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TiposContratoService {
    default TiposContratoEntity DTOToEntity(TiposContratoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TiposContratoEntity.class);
    }

    default TiposContratoResponse EntityToResponse(TiposContratoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TiposContratoResponse.class);
    }

    List<TiposContratoResponse> listarTiposContrato();

    TiposContratoResponse createUpdateTiposContrato(TiposContratoDTO tiposContratoDTO);
}
