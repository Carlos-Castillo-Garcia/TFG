package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Intervinientes
 * @author Carlos Castillo
 */
public interface TBIIntervinientesService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<TBIIntervinientesEntity, TBIIntervinientesResponse> ENTITYTORESPONSE = new PropertyMap<TBIIntervinientesEntity, TBIIntervinientesResponse>() {
        protected void configure() {
            map().setTipoIntervinienteId(source.getTipoIntervinienteId().getIdTipoInterviniente());
            map().setTipoInterviniente(source.getTipoIntervinienteId().getTipoInterviniente());
            map().setClienteId(source.getClienteId().getIdCliente());
            map().setContratosId(source.getContratosId().getIdContratos());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param intervinientesDTO parametro necesario para la ejecucion del metodo
     * @return TBIIntervinientesEntity
     */
    default TBIIntervinientesEntity DTOToEntity(TBIIntervinientesDTO intervinientesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(intervinientesDTO, TBIIntervinientesEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param tbiIntervinientesEntity parametro necesario para la ejecucion del metodo
     * @return TBIIntervinientesResponse
     */
    default TBIIntervinientesResponse EntityToResponse(TBIIntervinientesEntity tbiIntervinientesEntity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        TBIIntervinientesResponse tbiIntervinientesResponse = modelMapper.map(tbiIntervinientesEntity, TBIIntervinientesResponse.class);
        tbiIntervinientesResponse.setApellidosNombreCliente(tbiIntervinientesEntity.getClienteId().getApellidos() + ", " + tbiIntervinientesEntity.getClienteId().getNombre());

        return tbiIntervinientesResponse;
    }

    List<TBIIntervinientesResponse> listarIntervinientesContratoId(int id);

    List<TBIIntervinientesResponse> listarIntervinientesidIntervinientes(int id);

    TBIIntervinientesResponse createUpdateIntervinientes(TBIIntervinientesDTO intervinientesDTO);
}
