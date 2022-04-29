package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/UsuarioRoles")
public class UsuarioRolesController {

    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    @Autowired
    @Qualifier("RolesServiceImpl")
    private RolesServiceImpl rolesService;

    @PostMapping("/")
    public UsuariosResponse crearUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO){
       return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

    @GetMapping("/")
    public List<UsuariosResponse> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/")
    public UsuariosResponse updateUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO){
       return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

    @PostMapping("/")
    public RolesResponse crearRol(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesService.createUpdateRoles(rolesDTO);
    }

    @GetMapping("/")
    public List<RolesResponse> listarRoles(){
        return rolesService.listarRoles();
    }

    @PutMapping("/")
    public RolesResponse updateRoles(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesService.createUpdateRoles(rolesDTO);
    }

}
