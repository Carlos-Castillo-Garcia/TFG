package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    @Qualifier(value = "UsuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    @PostMapping
    public UsuariosResponse crearUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO) {
        return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

    @GetMapping("{id}")
    public List<UsuariosResponse> listarUsuariosIdAdministrador(@Valid @PathVariable("id") int idAdministrador) {
        return usuarioService.listarUsuariosIdAdministrador(idAdministrador);
    }

    @GetMapping("detalle/{id}")
    public List<UsuariosResponse> listarUsuarios(@Valid @PathVariable("id") int idUsuario) {
        return usuarioService.listarUsuariosIdUsuario(idUsuario);
    }

    @GetMapping("/loggin/{email}/{password}")
    public UsuariosResponse loggin(@Valid @PathVariable("email") String email, @Valid @PathVariable("password") String password) {
        return usuarioService.loggin(email, password);
    }

    @PutMapping
    public UsuariosResponse updateUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO) {
        return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

}
