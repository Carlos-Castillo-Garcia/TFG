package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface TBIContratosService {

    PropertyMap<TBIContratosEntity, TBIContratosResponse> ENTITYTORESPONSE = new PropertyMap<TBIContratosEntity, TBIContratosResponse>() {
        protected void configure() {
            map().setTipoContratoId(source.getTipoContratoId().getIdTipoContrato());
            map().setTipoPeriodoId(source.getTipoPeriodoId().getIdTipoPeriodo());
            map().setInmuebleId(source.getInmuebleId().getIdInmueble());
        }
    };

    default TBIContratosEntity DTOToEntity(TBIContratosDTO contratos){
        ModelMapper modelMapper = new ModelMapper();
        TBIContratosEntity contratosEntity = modelMapper.map(contratos, TBIContratosEntity.class);
        return contratosEntity;
    }

    default TBIContratosResponse EntityToResponse(TBIContratosEntity contratos){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        TBIContratosResponse contratosResponse = modelMapper.map(contratos, TBIContratosResponse.class);
        contratosResponse.setAliasInmueble(contratos.getInmuebleId().getAlias());
        contratosResponse.setTipoContrato(contratos.getTipoContratoId().getTipoContrato());
        contratosResponse.setTipoPeriodo(contratos.getTipoPeriodoId().getTipoPeriodo());
        return contratosResponse;
    }

    List<TBIContratosResponse> listarContratosadministradorId(int id);

    List<TBIContratosResponse> listarContratosidContratos(int id);

    TBIContratosResponse createUpdateContratos(TBIContratosDTO tbiContratosDTO);
}
