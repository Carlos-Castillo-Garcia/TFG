package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.InformesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("api/v1/informe")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InformesController {

    //-------------------------------------------Variable Service del controller de IngresoGasto----------------------------------------------
    @Autowired
    @Qualifier("InformesServiceImpl")
    private InformesServiceImpl informesService;

    @GetMapping("/inmueble/{idEntidad}")
    public List<InformesResponse> globalXInmueble(
            @PathVariable("idEntidad") int idEntidad) {
        return informesService.informeXInmueble(idEntidad);
    }

    @GetMapping("/inmueble/anio/{idInmueble}")
    public List<InformesResponse> globalByInmuebleXAnio(
            @PathVariable("idInmueble") int id) {
        return informesService.informeByInmuebleXAnio(id);
    }

    @GetMapping("/inmueble/mes/{idInmueble}/{anio}")
    public List<InformesResponse> globalByInmuebleAnioXMes(
            @PathVariable("idInmueble") int id,
            @PathVariable("anio") int anio) {
        return informesService.informeByInmuebleAnioXMes(id, anio);
    }
}
