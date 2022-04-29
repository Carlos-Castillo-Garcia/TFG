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

@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("UsuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier("RolesServiceImpl")
    private RolesServiceImpl rolesService;


    @Override
    public List<UsuariosResponse> listarUsuarios() {
        List<UsuariosResponse> usuariosResponseList = new ArrayList<>();
        for (UsuariosEntity i: usuarioRepository.findAll()) {
            if (i.getBorrado() == 0) {
                usuariosResponseList.add(EntityToResponse(i));
            }
        }
        return usuariosResponseList;
    }

    @Override
    public UsuariosResponse createUpdateUsuarios(UsuariosDTO usuariosDTO) {
        return EntityToResponse(usuarioRepository.save(DTOToEntity(usuariosDTO)));
    }

}
