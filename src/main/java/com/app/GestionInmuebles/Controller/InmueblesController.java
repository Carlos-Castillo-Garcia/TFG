package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.InmueblesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/inmuebles")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InmueblesController {

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;

    @PostMapping
    public InmuebleResponse createInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        return inmueblesService.createUpdateInmuebles(inmuebleDTO);
    }

    @GetMapping("/{id}")
    public List<InmuebleResponse> listarInmueblesIdAdministrador(@Valid @PathVariable("id") int id){
        return inmueblesService.listarInmueblesIdAdministrador(id);
    }

    @GetMapping("/detalle/{id}")
    public List<InmuebleResponse> listarInmueblesIdInmueble(@Valid @PathVariable("id") int id){
        return inmueblesService.listarInmueblesIdInmueble(id);
    }

    @PutMapping
    public InmuebleResponse updateInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        return inmueblesService.createUpdateInmuebles(inmuebleDTO);
    }
}
