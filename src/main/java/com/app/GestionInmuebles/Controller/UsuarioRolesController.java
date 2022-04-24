package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import com.app.GestionInmuebles.DTO.Roles.RolesResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.UsuarioServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    public void CrearUsuario(@RequestParam String nombre,
                             @RequestParam String email,
                             @RequestParam String password, @RequestBody RolesDTO rol){
        usuarioService.CrearUsuarios(nombre, email, password, rol);
    }

    @GetMapping("/listUsuarios")
    public List<UsuariosResponse> listarUsuarios(){
        return usuarioService.listar_usuarios();
    }

    @PostMapping("/crearRol")
    public void CrearRol(@RequestParam String nombre){
        rolesService.CrearRoles(nombre);
    }

    @GetMapping("/listRoles")
    public List<RolesResponse> listarRoles(){
        return rolesService.listar_Roles();
    }
}
