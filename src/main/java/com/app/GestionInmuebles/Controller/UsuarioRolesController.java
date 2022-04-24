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

    @PostMapping("/crearUsuario")
    public void CrearUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO){
        usuarioService.crearUsuarios(usuariosDTO);
    }

    @GetMapping("/listUsuarios")
    public List<UsuariosResponse> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/crearRol")
    public RolesResponse CrearRol(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesService.CrearRoles(rolesDTO);
    }

    @GetMapping("/listRoles")
    public List<RolesResponse> listarRoles(){
        return rolesService.listarRoles();
    }
}
