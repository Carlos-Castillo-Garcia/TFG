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
    public ClientesResponse createCliente(@Valid @RequestBody ClientesDTO cliente){
        return clienteService.createUpdateClientes(cliente);
    }

    @GetMapping
    public List<ClientesResponse> listClientes(){
        return clienteService.listarClientes();
    }

    @PutMapping
    public ClientesResponse updateCliente(@Valid @RequestBody ClientesDTO cliente){
        return clienteService.createUpdateClientes(cliente);
    }
}
