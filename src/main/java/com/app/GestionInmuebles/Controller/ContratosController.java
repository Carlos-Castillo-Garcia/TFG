package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TBIContratosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Contratos")
public class ContratosController {
    @Autowired
    @Qualifier("TBIContratosServiceImpl")
    private TBIContratosServiceImpl tbiContratosService;

    @GetMapping
    public List<TBIContratosResponse> listarContratos(){
        return tbiContratosService.listarContratos();
    }

    @PostMapping
    public TBIContratosResponse crearContratos(@Valid @RequestBody TBIContratosDTO tbiContratosDTO){
        return tbiContratosService.CrearContratos(tbiContratosDTO);
    }

}
