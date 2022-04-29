package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.InmueblesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/InmueblesClientes")
public class InmueblesClientesController {

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;

    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @Operation(description = "prueba")
    @PostMapping("/Inmueble")
    public InmuebleResponse CrearInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        return inmueblesService.CrearInmuebles(inmuebleDTO);
    }

    @GetMapping("/Inmuebles")
    public List<InmuebleResponse> ListarInmuebles(){
        return inmueblesService.listarInmuebles();
    }

    @PostMapping("/Cliente")
    public ClientesResponse CrearCliente(@Valid @RequestBody ClientesDTO cliente){
        return clienteService.crearClientes(cliente);
    }

    @GetMapping("/Clientes")
    public List<ClientesResponse> ListarClientes(){
        return clienteService.listarClientes();
    }


}
