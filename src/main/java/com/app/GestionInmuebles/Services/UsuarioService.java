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
        UsuariosEntity usuariosEntity = modelMapper.map(user, UsuariosEntity.class);
        return usuariosEntity;
    }

    default UsuariosResponse EntityToResponse(UsuariosEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        UsuariosResponse usuariosResponse = modelMapper.map(user, UsuariosResponse.class);
        return usuariosResponse;
    }

    List<UsuariosResponse> listar_usuarios();

    void CrearUsuarios(String nombre, String password, String email, RolesDTO roles);
}
