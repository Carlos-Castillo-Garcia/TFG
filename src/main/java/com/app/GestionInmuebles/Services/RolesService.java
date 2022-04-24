package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface RolesService {
    default RolesEntity DTOToEntity(RolesDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        RolesEntity rolesEntity = modelMapper.map(rol, RolesEntity.class);
        return rolesEntity;
    }

    RolesResponse EntityToResponse(RolesEntity rol);

    List<RolesResponse> listar_Roles();

    void CrearRoles(String nombre_rol);
}
