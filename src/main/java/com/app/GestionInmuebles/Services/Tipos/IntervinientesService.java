package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Tipos de Interviniente
 * @author Carlos Castillo
 */
public interface IntervinientesService {

    /**
     * Mapper de DTO a Entity
     * @param tipoIntervinienteDTO parametro necesario para la ejecucion del metodo
     * @return IntervinientesEntity
     */
    default IntervinientesEntity DTOToEntity(IntervinientesDTO tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, IntervinientesEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param tipoIntervinienteDTO parametro necesario para la ejecucion del metodo
     * @return IntervinientesResponse
     */
    default IntervinientesResponse EntityToResponse(IntervinientesEntity tipoIntervinienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoIntervinienteDTO, IntervinientesResponse.class);
    }

    List<IntervinientesResponse> listTipoIntervinientesadministradorId(int id);

    List<IntervinientesResponse> listTipoIntervinientesidIntervinientes(int id);

    IntervinientesResponse createUpdateTipoIntervinientes(IntervinientesDTO tipoIntervinienteDTO);
}
