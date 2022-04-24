package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.InmueblesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.TiposContratoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inmuebles")
public class InmueblesContratosController {

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;

    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @PostMapping("/crearInmueble")
    public InmuebleResponse CrearInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        return inmueblesService.CrearInmuebles(inmuebleDTO);
    }

    @GetMapping("/getInmuebles")
    public List<InmuebleResponse> ListarInmuebles(){
        return inmueblesService.listarInmuebles();
    }

    @PostMapping("/crearCliente")
    public ClientesResponse CrearCliente(@Valid @RequestBody ClientesDTO cliente){
        return clienteService.crearClientes(cliente);
    }

    @GetMapping("/getClientes")
    public List<ClientesResponse> ListarClientes(){
        return clienteService.listarClientes();
    }
}
