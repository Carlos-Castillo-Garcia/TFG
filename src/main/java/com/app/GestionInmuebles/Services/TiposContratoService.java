package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TiposContratoService {
    default TiposContratoEntity DTOToEntity(TiposContratoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        TiposContratoEntity tiposContratoEntity = modelMapper.map(i, TiposContratoEntity.class);
        return tiposContratoEntity;
    }

    default TiposContratoResponse EntityToResponse(TiposContratoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        TiposContratoResponse tiposContratoResponse = modelMapper.map(i, TiposContratoResponse.class);
        return tiposContratoResponse;
    }

    List<TiposContratoResponse> ListarTipos();

    void CrearTipos(String tipo_contrato, String tipo_interviniete);
}
