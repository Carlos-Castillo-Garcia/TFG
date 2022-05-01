package com.app.GestionInmuebles.Controller;

import com.TFG.Usuarios.DTO.Usuarios.UsuariosDTO;
import com.TFG.Usuarios.DTO.Usuarios.UsuariosResponse;
import com.TFG.Usuarios.Service.ServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Usuario")
public class UsuarioController {

    @Autowired
    @Qualifier(value = "UsuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    @PostMapping
    public UsuariosResponse crearUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO){
       return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

    @GetMapping
    public List<UsuariosResponse> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping
    public UsuariosResponse updateUsuario(@Valid @RequestBody UsuariosDTO usuariosDTO){
       return usuarioService.createUpdateUsuarios(usuariosDTO);
    }

}
