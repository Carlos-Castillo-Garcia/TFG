package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;


public interface IngresoGastoDetalleService {
    PropertyMap<IngresoGastoDetalleEntity, IngresoGastoDetalleResponse> ENTITYTORESPONSE = new PropertyMap<IngresoGastoDetalleEntity, IngresoGastoDetalleResponse>() {
        protected void configure() {
            map().setUsuarioId(source.getUsuarioId());
            map().setAdministradorId(source.getAdministradorId());
            map().setInGaId(source.getInGaId().getIdInGa());
        }
    };

    default IngresoGastoDetalleEntity DTOToEntity(IngresoGastoDetalleDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoDetalleEntity.class);
    }

    default IngresoGastoDetalleResponse EntityToResponse(IngresoGastoDetalleEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(i, IngresoGastoDetalleResponse.class);
    }

    List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleAdministradorId(int id);

    List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleId(int id);

    IngresoGastoDetalleResponse createUpdateIngresoGastoDetalle(IngresoGastoDetalleDTO i);
}
