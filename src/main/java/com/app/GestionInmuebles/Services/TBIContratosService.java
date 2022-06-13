package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Contratos
 * @author Carlos Castillo
 */
public interface TBIContratosService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<TBIContratosEntity, TBIContratosResponse> ENTITYTORESPONSE = new PropertyMap<TBIContratosEntity, TBIContratosResponse>() {
        protected void configure() {
            map().setTipoContratoId(source.getTipoContratoId().getIdTipoContrato());
            map().setTipoPeriodoId(source.getTipoPeriodoId().getIdTipoPeriodo());
            map().setInmuebleId(source.getInmuebleId().getIdInmueble());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param contratos parametro necesario para la ejecucion del metodo
     * @return TBIContratosEntity
     */
    default TBIContratosEntity DTOToEntity(TBIContratosDTO contratos){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(contratos, TBIContratosEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param contratos parametro necesario para la ejecucion del metodo
     * @return TBIContratosResponse
     */
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

    List<TBIContratosResponse> listarContratosPropietario(int idAdministrador, int entidad);

    List<TBIContratosResponse> listarContratosidContratos(int id);

    TBIContratosResponse createUpdateContratos(TBIContratosDTO tbiContratosDTO);
}
