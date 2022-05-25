package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TBIIntervinientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/interviniente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IntervinientesController {

    @Autowired
    @Qualifier("TBIIntervinientesServiceImpl")
    private TBIIntervinientesServiceImpl tbiIntervinientesService;

    @GetMapping("/{id}")
    public List<TBIIntervinientesResponse> listIntervinientesContratosId(@Valid @PathVariable("id") int id){
        return tbiIntervinientesService.listarIntervinientesContratoId(id);
    }

    @GetMapping("/detalle/{id}")
    public List<TBIIntervinientesResponse> listIntervinientesidIntervininetes(@Valid @PathVariable("id") int id){
        return tbiIntervinientesService.listarIntervinientesidIntervinientes(id);
    }

    @PostMapping
    public TBIIntervinientesResponse createIntervinientes(@Valid @RequestBody TBIIntervinientesDTO intervinientesDTO){
        return tbiIntervinientesService.createUpdateIntervinientes(intervinientesDTO);
    }

    @PutMapping
    public TBIIntervinientesResponse updateIntervinientes(@Valid @RequestBody TBIIntervinientesDTO intervinientesDTO){
        return tbiIntervinientesService.createUpdateIntervinientes(intervinientesDTO);
    }
}
