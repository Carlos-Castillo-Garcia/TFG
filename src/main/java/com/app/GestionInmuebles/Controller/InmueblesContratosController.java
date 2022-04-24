package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.ClienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.InmueblesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.TiposContratoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inmuebles")
public class InmueblesContratosController {

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;


    @Autowired
    @Qualifier("TiposContratoServiceImpl")
    private TiposContratoServiceImpl tipos_contratoService;

    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @PostMapping("/crearInmueble")
    public void CrearInmueble(@RequestParam(name = "ref") String ref,
                              @RequestParam(name = "alias") String alias,
                              @RequestParam(name = "localidad") String localidad,
                              @RequestParam(name = "direccion") String direccion,
                              @RequestParam(name = "cp") int cp){
        inmueblesService.CrearInmuebles(ref, alias, localidad, direccion, cp
        );
    }

    @GetMapping("/getInmuebles")
    public List<InmuebleResponse> ListarInmuebles(){
        return inmueblesService.listar_Inmuebles();
    }

    @PostMapping("/crearTipos")
    public void CrearTipos(@RequestParam(name = "contrato") String contrato,
                           @RequestParam(name = "interviniente") String interviniente){
        tipos_contratoService.CrearTipos(contrato, interviniente);
    }

    @GetMapping("/getTipos")
    public List<TiposContratoResponse> ListarContratos(){
        return tipos_contratoService.ListarTipos();
    }

    @PostMapping("/crearCliente")
    public void CrearCliente(@RequestBody ClientesDTO cliente){
        clienteService.CrearClientes(cliente);
    }

    @GetMapping("/getClientes")
    public List<ClientesResponse> ListarClientes(){
        return clienteService.listar_Clientes();
    }
}
