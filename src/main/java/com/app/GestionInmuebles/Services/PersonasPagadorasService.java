package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasDTO;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasEntity;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasResponse;
import org.modelmapper.ModelMapper;

/**
 * Interfaz de Personas Pagadoras
 * @author Carlos Castillo
 */
public interface PersonasPagadorasService {

    /**
     * Mapper de DTO a Entity
     * @param personasPagadorasDTO parametro necesario para la ejecucion del metodo
     * @return PersonasPagadorasEntity
     */
    default PersonasPagadorasEntity DTOToEntity(PersonasPagadorasDTO personasPagadorasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personasPagadorasDTO, PersonasPagadorasEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param personasPagadorasEntity parametro necesario para la ejecucion del metodo
     * @return PersonasPagadorasResponse
     */
    default PersonasPagadorasResponse EntityToResponse(PersonasPagadorasEntity personasPagadorasEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personasPagadorasEntity, PersonasPagadorasResponse.class);
    }

    PersonasPagadorasResponse listaridPersonasPagadoras(int id);

    PersonasPagadorasResponse createUpdatePersonasPagadoras(PersonasPagadorasDTO i);
}
