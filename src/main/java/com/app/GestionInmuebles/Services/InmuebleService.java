package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Inmuebles
 * @author Carlos Castillo
 */
public interface InmuebleService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<InmuebleEntity, InmuebleResponse> ENTITYTORESPONSE = new PropertyMap<InmuebleEntity, InmuebleResponse>() {
        protected void configure() {
            map().setTipoCategoriaId(source.getIdTipoInmueble().getCategoriaId().getIdCategoria());
            map().setTipoCategoria(source.getIdTipoInmueble().getCategoriaId().getCategoria());
            map().setTipoInmueblesId(source.getIdTipoInmueble().getIdTipoInmueble());
            map().setTipoInmueble(source.getIdTipoInmueble().getTipoInmueble());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param inmueble parametro necesario para la ejecucion del metodo
     * @return InmuebleEntity
     */
    default InmuebleEntity DTOToEntity(InmuebleDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inmueble, InmuebleEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param inmueble parametro necesario para la ejecucion del metodo
     * @return InmuebleResponse
     */
    default InmuebleResponse EntityToResponse(InmuebleEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(inmueble, InmuebleResponse.class);
    }

    List<InmuebleResponse> listarInmueblesIdAdministrador(int idAdministrador);

    List<InmuebleResponse> listarInmueblesIdInmueble(int idInmueble);

    List<InmuebleResponse> inmueblesByPorcentajeContratoAndEntidad(int idAdministrador, int entidad);

    InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO);

    List<InmueblesXClientesRespone> propiedad(int idCliente);

    List<InversionResponse> inversion(int idInmueble);
}
