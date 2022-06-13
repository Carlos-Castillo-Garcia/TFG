package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.InmueblesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("api/v1/inmueble")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InmueblesController {

    //-------------------------------------------Variable Service del controller de Inmuebles----------------------------------------------

    @Autowired
    @Qualifier("InmueblesServiceImpl")
    private InmueblesServiceImpl inmueblesService;

    //-------------------------------------------Metodos del controller de Inmuebles-------------------------------------------------------

    @PostMapping
    public InmuebleResponse createInmueble(@RequestBody InmuebleDTO inmuebleDTO) {
        return inmueblesService.createUpdateInmuebles(inmuebleDTO);
    }

    @PutMapping
    public InmuebleResponse updateInmueble(@RequestBody InmuebleDTO inmuebleDTO) {
        return inmueblesService.createUpdateInmuebles(inmuebleDTO);
    }

    @GetMapping("/{id}")
    public List<InmuebleResponse> listarInmueblesIdAdministrador(@PathVariable("id") int id) {
        return inmueblesService.listarInmueblesIdAdministrador(id);
    }

    @GetMapping("/{idAdministrador}/{entidad}")
    public List<InmuebleResponse> inmueblesByPorcentajeContratoAndEntidad(
            @PathVariable("idAdministrador") int idAdministrador,
            @PathVariable("entidad") int entidad) {
        return inmueblesService.inmueblesByPorcentajeContratoAndEntidad(idAdministrador, entidad);
    }

    @GetMapping("/detalle/{id}")
    public List<InmuebleResponse> listarInmueblesIdInmueble(@PathVariable("id") int id) {
        return inmueblesService.listarInmueblesIdInmueble(id);
    }

    @GetMapping("/cliente/{idInmueble}")
    public List<InmueblesXClientesRespone> listarInmueblesXClientes(@PathVariable("idInmueble") int id) {
        return inmueblesService.propiedad(id);
    }

    @GetMapping("/inversiones/{idInmueble}")
    public List<InversionResponse> listarInversiones(@PathVariable("idInmueble") int id) {
        return inmueblesService.inversion(id);
    }

}
