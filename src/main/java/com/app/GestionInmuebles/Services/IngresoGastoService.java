package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface IngresoGastoService {
    PropertyMap<IngresoGastoEntity, IngresoGastoResponse> ENTITYTORESPONSE = new PropertyMap<IngresoGastoEntity, IngresoGastoResponse>() {
        protected void configure() {
            map().setInmuebleId(source.getInmuebleId().getIdInmueble());
            map().setClienteId(source.getClienteId().getIdCliente());
            map().setTipoConceptoId(source.getTipoConceptoId().getIdTipoConcepto());
            map().setTipoPagoId(source.getTipoPagoId().getIdTipoPago());
            map().setUsuarioId(source.getUsuarioId());
            map().setAdministradorId(source.getAdministradorId());
        }
    };

    default IngresoGastoEntity DTOToEntity(IngresoGastoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoEntity.class);
    }

    default IngresoGastoResponse EntityToResponse(IngresoGastoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(i, IngresoGastoResponse.class);
    }

    List<IngresoGastoResponse> listarIngresoGastoInmuebleId(int id);

    List<IngresoGastoResponse> listarIngresoGastoId(int id);

    IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i);
}
