package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Clientes")
public class ClientesController {

    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @PostMapping
    public ClientesResponse CrearCliente(@Valid @RequestBody ClientesDTO cliente){
        return clienteService.crearClientes(cliente);
    }

    @GetMapping
    public List<ClientesResponse> ListarClientes(){
        return clienteService.listarClientes();
    }


}
