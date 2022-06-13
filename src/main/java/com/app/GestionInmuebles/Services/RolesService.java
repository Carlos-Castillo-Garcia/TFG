package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Roles
 * @author Carlos Castillo
 */
public interface RolesService {

    /**
     * Mapper de DTO a Entity
     * @param rol parametro necesario para la ejecucion del metodo
     * @return RolesEntity
     */
    default RolesEntity DTOToEntity(RolesDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rol, RolesEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param rol parametro necesario para la ejecucion del metodo
     * @return RolesResponse
     */
    default RolesResponse EntityToResponse(RolesEntity rol) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rol, RolesResponse.class);
    }

    List<RolesResponse> listarRolesadministradorId(int id);

    List<RolesResponse> listarRolesidRoles(int id);

    RolesResponse createUpdateRoles(RolesDTO rolesDTO);
}
