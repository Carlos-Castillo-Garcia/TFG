package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasDTO;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasEntity;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasResponse;
import org.modelmapper.ModelMapper;

public interface PersonasPagadorasService {
    default PersonasPagadorasEntity DTOToEntity(PersonasPagadorasDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, PersonasPagadorasEntity.class);
    }

    default PersonasPagadorasResponse EntityToResponse(PersonasPagadorasEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, PersonasPagadorasResponse.class);
    }

    PersonasPagadorasResponse listaridPersonasPagadoras(int id);

    PersonasPagadorasResponse createUpdatePersonasPagadoras(PersonasPagadorasDTO i);
}
