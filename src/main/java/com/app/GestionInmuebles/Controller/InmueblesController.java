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
@RequestMapping("api/v1/Inmuebles")
public class InmueblesController {

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;

    @Operation(description = "prueba")
    @PostMapping
    public InmuebleResponse CrearInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        return inmueblesService.CrearInmuebles(inmuebleDTO);
    }

    @GetMapping
    public List<InmuebleResponse> ListarInmuebles(){
        return inmueblesService.listarInmuebles();
    }
}
