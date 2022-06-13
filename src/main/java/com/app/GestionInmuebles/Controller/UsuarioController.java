package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular

@RestController
@RequestMapping("api/v1/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    //-------------------------------------------Variable Service del controller de Inmuebles----------------------------------------------

    @Autowired
    @Qualifier(value = "UsuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    //-------------------------------------------Metodos del controller de Inmuebles-------------------------------------------------------


    @PostMapping
    public UsuariosResponse crearUsuario( @RequestBody UsuariosDTO usuariosDTO) {
        return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

    @GetMapping("{id}")
    public List<UsuariosResponse> listarUsuariosIdAdministrador( @PathVariable("id") int idAdministrador) {
        return usuarioService.listarUsuariosIdAdministrador(idAdministrador);
    }

    @GetMapping("detalle/{id}")
    public List<UsuariosResponse> listarUsuarios( @PathVariable("id") int idUsuario) {
        return usuarioService.listarUsuariosIdUsuario(idUsuario);
    }

    @GetMapping("/loggin/{email}/{password}")
    public UsuariosResponse loggin( @PathVariable("email") String email,  @PathVariable("password") String password) {
        return usuarioService.loggin(email, password);
    }

    @PutMapping
    public UsuariosResponse updateUsuario( @RequestBody UsuariosDTO usuariosDTO) {
        return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

}
