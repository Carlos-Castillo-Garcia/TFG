package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasDTO;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.PersonasPagadorasServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/personaspagadoras")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PersonasPagadorasController {

    @Autowired
    @Qualifier("PersonasPagadorasServiceImpl")
    private PersonasPagadorasServiceImpl personasPagadorasService;

    @Operation(
            summary = "Creado de Personas Pagadoras",
            description = "Metodo para la creacion de Personas Pagadoras",
            method = "POST"
    )
    @PostMapping
    public PersonasPagadorasResponse createPersonasPagadoras(
            @Parameter(
                    name = "Persona Pagadora",
                    description = "Objeto de tipo Cliente para la creacion del registro",
                    required = true
            )
            @Valid @RequestBody PersonasPagadorasDTO personasPagadorasDTO) {
        return personasPagadorasService.createUpdatePersonasPagadoras(personasPagadorasDTO);
    }

    @Operation(
            summary = "Modificacion de Persona Pagadora",
            description = "Metodo para la modificacion de Persona Pagadora",
            method = "PUT"
    )
    @PutMapping
    public PersonasPagadorasResponse updateCliente(
            @Parameter(
                    name = "Persona Pagadora",
                    description = "Objeto de tipo Persona Pagadora para la modificacion del registro",
                    required = true
            )
            @Valid @RequestBody PersonasPagadorasDTO personaPagadoraDto) {
        return personasPagadorasService.createUpdatePersonasPagadoras(personaPagadoraDto);
    }

    @Operation(
            summary = "Listado de Personas Pagadoras",
            description = "Metodo para la obtencion de Persona Pagadora",
            method = "GET"
    )
    @GetMapping("/{id}")
    public PersonasPagadorasResponse listClientesadministradorId(
            @Parameter(
                    name = "Id",
                    description = "Id asociado a la Persona Pagadora para su posterior uso en el filtrado",
                    required = true
            )
            @Valid @PathVariable("id") int id) {
        return personasPagadorasService.listaridPersonasPagadoras(id);
    }

}
