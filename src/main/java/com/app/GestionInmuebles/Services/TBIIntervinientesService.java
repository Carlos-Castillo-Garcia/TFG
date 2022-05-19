package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface TBIIntervinientesService {

    PropertyMap<TBIIntervinientesEntity, TBIIntervinientesResponse> ENTITYTORESPONSE = new PropertyMap<TBIIntervinientesEntity, TBIIntervinientesResponse>() {
        protected void configure() {
            map().setTipoIntervinienteId(source.getTipoIntervinienteId().getIdTipoInterviniente());
            map().setClienteId(source.getClienteId().getIdCliente());
            map().setContratosId(source.getContratosId().getIdContratos());
        }
    };

    default TBIIntervinientesEntity DTOToEntity(TBIIntervinientesDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, TBIIntervinientesEntity.class);
    }

    default TBIIntervinientesResponse EntityToResponse(TBIIntervinientesEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(inmueble, TBIIntervinientesResponse.class);
    }

    List<TBIIntervinientesResponse> listarIntervinientesContratoId(int id);

    List<TBIIntervinientesResponse> listarIntervinientesidIntervinientes(int id);

    TBIIntervinientesResponse createUpdateIntervinientes(TBIIntervinientesDTO intervinientesDTO);
}
