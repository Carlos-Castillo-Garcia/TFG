package com.app.GestionInmuebles.Controller;

import com.TFG.Usuarios.DTO.Roles.RolesDTO;
import com.TFG.Usuarios.DTO.Roles.RolesResponse;
import com.TFG.Usuarios.Service.ServiceImpl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Roles")
public class RolesController {
    @Autowired
    @Qualifier(value = "RolesServiceImpl")
    private RolesServiceImpl rolesServiceImpl;

    @PostMapping
    public RolesResponse crearRol(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }

    @GetMapping
    public List<RolesResponse> listarRoles(){
        return rolesServiceImpl.listarRoles();
    }

    @PutMapping
    public RolesResponse updateRoles(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }

}
