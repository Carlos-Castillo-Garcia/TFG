package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientesController {

    //-------------------------------------------Variable Service del controller de Clientes----------------------------------------------
    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    //-------------------------------------------Metodos del controller de Clientes-------------------------------------------------------
    @Operation(
            summary = "Creado de Clientes",
            description = "Metodo para la creacion de Clientes",
            method = "POST"
    )
    @PostMapping
    public ClientesResponse createCliente(
            @Parameter(
                    name = "Cliente",
                    description = "Objeto de tipo Cliente para la creacion del registro",
                    required = true
            )
            @Valid @RequestBody ClientesDTO cliente) {
        return clienteService.createUpdateClientes(cliente);
    }

    @Operation(
            summary = "Modificacion de Clientes",
            description = "Metodo para la modificacion de Clientes",
            method = "PUT"
    )
    @PutMapping
    public ClientesResponse updateCliente(
            @Parameter(
                    name = "Cliente",
                    description = "Objeto de tipo Cliente para la modificacion del registro",
                    required = true
            )
            @Valid @RequestBody ClientesDTO cliente) {
        return clienteService.createUpdateClientes(cliente);
    }

    @Operation(
            summary = "Listado de Clientes",
            description = "Metodo para la obtencion de Clientes con filtrado del id de administrador",
            method = "GET"
    )
    @GetMapping("/{id}")
    public List<ClientesResponse> listClientesadministradorId(
            @Parameter(
                    name = "Id",
                    description = "Id administrador asociado al Cliente para su posterior uso en el filtrado",
                    required = true
            )
            @Valid @PathVariable("id") int id) {
        return clienteService.listarClientesadministradorId(id);
    }

    @Operation(
            summary = "Listado de Clientes",
            description = "Metodo para la obtencion del Cliente",
            method = "GET"
    )
    @GetMapping("detalle/{id}")
    public List<ClientesResponse> listClientesidCliente(
            @Parameter(
                    name = "Id",
                    description = "Id cliente para su posterior uso en el filtrado",
                    required = true
            )
            @Valid @PathVariable("id") int id) {
        return clienteService.listarClientesidCliente(id);
    }

}
