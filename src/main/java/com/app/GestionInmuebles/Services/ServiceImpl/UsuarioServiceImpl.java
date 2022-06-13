package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Repository.UsuarioRepository;
import com.app.GestionInmuebles.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    //-------------------------------------------Variable Service de Usuario Repository----------------------------------------------
    @Autowired
    @Qualifier("UsuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier("RolesServiceImpl")
    private RolesServiceImpl rolesService;

    //-------------------------------------------Metodos de la Clase Usuario Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de UsuariosResponse
     */
    @Override
    public List<UsuariosResponse> listarUsuariosIdAdministrador(int id) {
        List<UsuariosResponse> usuariosResponseList = new ArrayList<>();
        for (UsuariosEntity i : usuarioRepository.getByadministradorId(id)) {
            if (!i.isBorrado()) {
                usuariosResponseList.add(EntityToResponse(i));
            }
        }
        return usuariosResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de UsuariosResponse
     */
    @Override
    public List<UsuariosResponse> listarUsuariosIdUsuario(int id) {
        List<UsuariosResponse> usuariosResponseList = new ArrayList<>();
        for (UsuariosEntity i : usuarioRepository.getByidUsuario(id)) {
            usuariosResponseList.add(EntityToResponse(i));
        }
        return usuariosResponseList;
    }

    /**
     *  Metodo usado para la creacion y modificacion
     * @param usuariosDTO parametro necesario para la ejecucion del metodo
     * @return UsuariosResponse
     */
    @Override
    public UsuariosResponse createUpdateUsuarios(UsuariosDTO usuariosDTO) {
        return EntityToResponse(usuarioRepository.save(DTOToEntity(usuariosDTO)));
    }

    /**
     * Metodo para la para la comprobacion de que el email y la contraseña ingresados existan en la base de datos
     * @param email parametro necesario para la ejecucion del metodo
     * @param password parametro necesario para la ejecucion del metodo
     * @return UsuariosResponse
     */
    @Override
    public UsuariosResponse loggin(String email, String password) {
        return EntityToResponse(usuarioRepository.getByEmailAndPassword(email, password));
    }

}
