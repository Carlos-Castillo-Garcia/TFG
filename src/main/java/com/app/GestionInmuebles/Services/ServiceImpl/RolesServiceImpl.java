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

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("RolesServiceImpl")
public class RolesServiceImpl implements RolesService {

    //-------------------------------------------Variable Service de Roles Repository----------------------------------------------
    @Autowired
    @Qualifier(value = "RolesRepository")
    private RolesRepository rolesRepository;

    //-------------------------------------------Metodos de la Clase Roles Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de RolesResponse
     */
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

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de RolesResponse
     */
    @Override
    public List<RolesResponse> listarRolesidRoles(int id) {
        List<RolesResponse> rolesResponseList = new ArrayList<>();
        for (RolesEntity i : rolesRepository.findAllByidRol(id)) {
            rolesResponseList.add(EntityToResponse(i));
        }
        return rolesResponseList;
    }

    /**
     * Metodo para la usado creacion y modificacion
     * @param rolesDTO parametro necesario para la ejecucion del metodo
     * @return RolesResponse
     */
    @Override
    public RolesResponse createUpdateRoles(RolesDTO rolesDTO) {
        return EntityToResponse(rolesRepository.save(DTOToEntity(rolesDTO)));
    }

}