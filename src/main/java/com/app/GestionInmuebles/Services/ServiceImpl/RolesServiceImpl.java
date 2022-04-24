package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
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
    public List<RolesResponse> listarRoles() {
        List<RolesResponse> rolesResponseList = new ArrayList<>();
        for (RolesEntity i: rolesRepository.findAll()) {
            rolesResponseList.add(EntityToResponse(i));
        }
        return rolesResponseList;
    }

    @Override
    public RolesResponse CrearRoles(RolesDTO rolesDTO) {
        return EntityToResponse(rolesRepository.save(DTOToEntity(rolesDTO)));
    }
}
