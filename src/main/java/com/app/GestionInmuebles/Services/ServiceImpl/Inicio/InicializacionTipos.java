package com.app.GestionInmuebles.Services.ServiceImpl.Inicio;

import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InicializacionTipos implements ApplicationRunner {

    @Autowired
    private RolesServiceImpl rolesService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nombre_roles = new ArrayList<>();
        nombre_roles.add("administrador");
        nombre_roles.add("gestor");
        nombre_roles.add("inquilino");
        nombre_roles.add("propietario");
        nombre_roles.add("visitante");
        RolesDTO rolesDTO = new RolesDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(rolesService.listarRolesadministradorId(0).size() == 0){
            for (String nombre_rol : nombre_roles) {
                rolesDTO.setNombreRol(nombre_rol);
                rolesService.createUpdateRoles(rolesDTO);
            }
        }
    }
}
