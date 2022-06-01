package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface InmuebleService {
    PropertyMap<InmuebleEntity, InmuebleResponse> ENTITYTORESPONSE = new PropertyMap<InmuebleEntity, InmuebleResponse>() {
        protected void configure() {
            map().setTipoCategoriaId(source.getIdTipoInmueble().getCategoriaId().getIdCategoria());
            map().setTipoCategoria(source.getIdTipoInmueble().getCategoriaId().getCategoria());
            map().setTipoInmueblesId(source.getIdTipoInmueble().getIdTipoInmueble());
            map().setTipoInmueble(source.getIdTipoInmueble().getTipoInmueble());
        }
    };

    default InmuebleEntity DTOToEntity(InmuebleDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        InmuebleEntity inmuebleEntity = modelMapper.map(inmueble, InmuebleEntity.class);
        return inmuebleEntity;
    }

    default InmuebleResponse EntityToResponse(InmuebleEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        InmuebleResponse inmuebleResponse = modelMapper.map(inmueble, InmuebleResponse.class);
        return inmuebleResponse;
    }

    List<InmuebleResponse> listarInmueblesIdAdministrador(int idAdministrador);

    List<InmuebleResponse> listarInmueblesIdInmueble(int idInmueble);

    InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO);
}
