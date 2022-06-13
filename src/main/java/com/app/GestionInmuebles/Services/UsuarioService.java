package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Usuarios
 * @author Carlos Castillo
 */
public interface UsuarioService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<UsuariosEntity, UsuariosResponse> ENTITYTORESPONSE = new PropertyMap<UsuariosEntity, UsuariosResponse>() {
        protected void configure() {
            map().setRolId(source.getRolId().getIdRol());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param user parametro necesario para la ejecucion del metodo
     * @return UsuariosEntity
     */
    default UsuariosEntity DTOToEntity(UsuariosDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UsuariosEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param user parametro necesario para la ejecucion del metodo
     * @return UsuariosResponse
     */
    default UsuariosResponse EntityToResponse(UsuariosEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        UsuariosResponse usuariosResponse = modelMapper.map(user, UsuariosResponse.class);
        usuariosResponse.setNombreRol(user.getRolId().getNombreRol());
        return usuariosResponse;
    }

    List<UsuariosResponse> listarUsuariosIdAdministrador(int id);

    List<UsuariosResponse> listarUsuariosIdUsuario(int id);

    UsuariosResponse createUpdateUsuarios(UsuariosDTO usuariosDTO);

    UsuariosResponse loggin(String email, String password);

}
