package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface UsuarioService {
    default UsuariosEntity DTOToEntity(UsuariosDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UsuariosEntity.class);
    }

    default UsuariosResponse EntityToResponse(UsuariosEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UsuariosResponse.class);
    }

    List<UsuariosResponse> listarUsuarios();

    UsuariosResponse createUpdateUsuarios(UsuariosDTO usuariosDTO);

}
