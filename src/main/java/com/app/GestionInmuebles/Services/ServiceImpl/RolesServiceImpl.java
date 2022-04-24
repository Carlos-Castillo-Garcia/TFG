package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.Repository.RolesRepository;
import com.app.GestionInmuebles.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("RolesServiceImpl")
public class RolesServiceImpl implements RolesService {

    @Autowired
    @Qualifier("RolesRepository")
    private RolesRepository rolesRepository;


    @Override
    public RolesResponse EntityToResponse(RolesEntity rol) {
        RolesResponse casteo = new RolesResponse();
        List<String> nombres = new ArrayList<>();
        casteo.setNombre_rol(rol.getNombre_rol());
        for (int i = 0; i< rol.getUsuario().size();i++){
            nombres.add(rol.getUsuario().get(i).getNombre());
        }
        casteo.setUsuario(nombres);
        return casteo;
    }

    @Override
    public List<RolesResponse> listar_Roles() {
        List<RolesResponse> rolesResponseList = new ArrayList<>();
        for (RolesEntity i: rolesRepository.findAll()) {
            rolesResponseList.add(this.EntityToResponse(i));
        }
        return rolesResponseList;
    }

    @Override
    public void CrearRoles(String nombre_rol) {
        RolesEntity rol = new RolesEntity();
        rol.setNombre_rol(nombre_rol);
        rolesRepository.save(rol);
    }
}
