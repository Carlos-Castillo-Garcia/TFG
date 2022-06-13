package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.ClientesXInmueblesServiceImpl;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientesController {

    //-------------------------------------------Variable Service del controller de Clientes----------------------------------------------
    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @Autowired
    @Qualifier("ClientesXInmueblesServiceImpl")
    private ClientesXInmueblesServiceImpl clientesXInmueblesService;

    //-------------------------------------------Metodos del controller de Clientes-------------------------------------------------------

    @PostMapping
    public ClientesResponse createCliente(
            @RequestBody ClientesDTO cliente) {
        return clienteService.createUpdateClientes(cliente);
    }

    @PutMapping
    public ClientesResponse updateCliente(
            @RequestBody ClientesDTO cliente) {
        return clienteService.createUpdateClientes(cliente);
    }

    @GetMapping("/{id}")
    public List<ClientesResponse> listClientesByAdministradorId(
            @PathVariable("id") int idAdministrador) {
        return clienteService.listarClientesadministradorId(idAdministrador);
    }

    @GetMapping("detalle/{id}")
    public List<ClientesResponse> listClientesByClienteId(
            @PathVariable("id") int idCliente) {
        return clienteService.listarClientesidCliente(idCliente);
    }

    @GetMapping("/byinmuebles/{id}")
    public List<ClientesResponse> listClientesByInmuebleId(
            @PathVariable("id") int id) {
        return clienteService.clienteByInmueble(id);
    }

    @GetMapping("xinmueble/{id}")
    public List<ClientesXInmueblesResponse> listClientesByInmuebles(
             @PathVariable("id") int idCliente) {
        return clientesXInmueblesService.clientesXInmueblesList(idCliente);
    }

    @GetMapping("inversion/{id}")
    public List<InversionResponse> inversionResponseList(
             @PathVariable("id") int idCliente) {
        return clienteService.inversion(idCliente);
    }
}
