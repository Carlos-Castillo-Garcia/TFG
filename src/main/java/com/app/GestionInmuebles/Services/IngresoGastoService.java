package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface IngresoGastoService {
    default IngresoGastoEntity DTOToEntity(IngresoGastoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoEntity.class);
    }

    default IngresoGastoResponse EntityToResponse(IngresoGastoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoResponse.class);
    }

    List<IngresoGastoResponse> listarIngresoGastoInmuebleId(int id);

    List<IngresoGastoResponse> listarIngresoGastoId(int id);

    IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i);
}
