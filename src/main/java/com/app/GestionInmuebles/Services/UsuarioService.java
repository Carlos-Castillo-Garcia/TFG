package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface UsuarioService {
    PropertyMap<UsuariosEntity, UsuariosResponse> ENTITYTORESPONSE = new PropertyMap<UsuariosEntity, UsuariosResponse>() {
        protected void configure() {
            map().setIdRol(source.getRolId().getIdRol());
        }
    };

    default UsuariosEntity DTOToEntity(UsuariosDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        UsuariosEntity usuariosEntity = modelMapper.map(user, UsuariosEntity.class);
        return usuariosEntity;
    }

    default UsuariosResponse EntityToResponse(UsuariosEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        UsuariosResponse usuariosResponse = modelMapper.map(user, UsuariosResponse.class);
        return usuariosResponse;
    }

    List<UsuariosResponse> listarUsuariosIdAdministrador(int id);

    List<UsuariosResponse> listarUsuariosIdUsuario(int id);

    UsuariosResponse createUpdateUsuarios(UsuariosDTO usuariosDTO);

    UsuariosResponse loggin(String email, String password);

}
