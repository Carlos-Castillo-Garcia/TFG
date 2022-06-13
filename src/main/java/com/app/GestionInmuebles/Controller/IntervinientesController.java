package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TBIIntervinientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/interviniente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IntervinientesController {

    //-------------------------------------------Variable Service del controller de Inmuebles----------------------------------------------

    @Autowired
    @Qualifier("TBIIntervinientesServiceImpl")
    private TBIIntervinientesServiceImpl tbiIntervinientesService;

    //-------------------------------------------Metodos del controller de Inmuebles-------------------------------------------------------

    @GetMapping("/{id}")
    public List<TBIIntervinientesResponse> listIntervinientesContratosId( @PathVariable("id") int id){
        return tbiIntervinientesService.listarIntervinientesContratoId(id);
    }

    @GetMapping("/detalle/{id}")
    public List<TBIIntervinientesResponse> listIntervinientesidIntervininetes( @PathVariable("id") int id){
        return tbiIntervinientesService.listarIntervinientesidIntervinientes(id);
    }

    @PostMapping
    public TBIIntervinientesResponse createIntervinientes( @RequestBody TBIIntervinientesDTO intervinientesDTO){
        return tbiIntervinientesService.createUpdateIntervinientes(intervinientesDTO);
    }

    @PutMapping
    public TBIIntervinientesResponse updateIntervinientes( @RequestBody TBIIntervinientesDTO intervinientesDTO){
        return tbiIntervinientesService.createUpdateIntervinientes(intervinientesDTO);
    }
}
