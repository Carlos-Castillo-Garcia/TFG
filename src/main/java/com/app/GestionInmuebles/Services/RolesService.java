package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface RolesService {
    default RolesEntity DTOToEntity(RolesDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rol, RolesEntity.class);
    }

    default RolesResponse EntityToResponse(RolesEntity rol){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rol, RolesResponse.class);
    }

    List<RolesResponse> listarRoles();

    RolesResponse createUpdateRoles(RolesDTO rolesDTO);
}
