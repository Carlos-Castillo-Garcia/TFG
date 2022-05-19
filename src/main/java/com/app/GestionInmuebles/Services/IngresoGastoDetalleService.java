package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import org.modelmapper.ModelMapper;

import java.util.List;


public interface IngresoGastoDetalleService {
    default IngresoGastoDetalleEntity DTOToEntity(IngresoGastoDetalleDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoDetalleEntity.class);
    }

    default IngresoGastoDetalleResponse EntityToResponse(IngresoGastoDetalleEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoDetalleResponse.class);
    }

    List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleAdministradorId(int id);

    List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleId(int id);

    IngresoGastoDetalleResponse createUpdateIngresoGastoDetalle(IngresoGastoDetalleDTO i);
}
