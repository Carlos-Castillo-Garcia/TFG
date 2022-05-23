package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesResponse;
import com.app.GestionInmuebles.Repository.RolesRepository;
import com.app.GestionInmuebles.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("RolesServiceImpl")
public class RolesServiceImpl implements RolesService {

    @Autowired
    @Qualifier(value = "RolesRepository")
    private RolesRepository rolesRepository;

    @Override
    public List<RolesResponse> listarRolesadministradorId(int id) {
        List<RolesResponse> rolesResponseList = new ArrayList<>();
        for (RolesEntity i : rolesRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                rolesResponseList.add(EntityToResponse(i));
            }
        }
        return rolesResponseList;
    }

    @Override
    public List<RolesResponse> listarRolesidRoles(int id) {
        List<RolesResponse> rolesResponseList = new ArrayList<>();
        for (RolesEntity i : rolesRepository.findAllByidRol(id)) {
            rolesResponseList.add(EntityToResponse(i));
        }
        return rolesResponseList;
    }

    @Override
    public RolesResponse createUpdateRoles(RolesDTO rolesDTO) {
        return EntityToResponse(rolesRepository.save(DTOToEntity(rolesDTO)));
    }

}