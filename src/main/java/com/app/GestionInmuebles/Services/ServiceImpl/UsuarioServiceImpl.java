package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
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

@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("UsuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier("RolesServiceImpl")
    private RolesServiceImpl rolesService;


    @Override
    public List<UsuariosResponse> listar_usuarios() {
        List<UsuariosResponse> usuariosResponseList = new ArrayList<>();
        for (UsuariosEntity i: usuarioRepository.findAll()) {
            usuariosResponseList.add(this.EntityToResponse(i));
        }
        return usuariosResponseList;
    }

    @Override
    public void CrearUsuarios(String nombre, String password, String email, RolesDTO rol) {
        UsuariosEntity usuario = new UsuariosEntity();
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setRol_id(rolesService.DTOToEntity(rol));
        usuarioRepository.save(usuario);
    }
}
