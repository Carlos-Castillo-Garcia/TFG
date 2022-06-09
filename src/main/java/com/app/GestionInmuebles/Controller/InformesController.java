package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.InformesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/informe")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InformesController {

    //-------------------------------------------Variable Service del controller de IngresoGasto----------------------------------------------
    @Autowired
    @Qualifier("InformesServiceImpl")
    private InformesServiceImpl informesService;

    @Operation(
            summary = "Listado de Ingreso Gasto",
            description = "Metodo para la obtencion de Ingreso Gasto con filtrado del id de Inmueble",
            method = "GET"
    )
    @GetMapping("/{id}")
    public InformesResponse global(
            @Valid @PathVariable("id") int id) {
        return informesService.informeGeneral(id);
    }

    @GetMapping("/inmueble/{administradorId}/{idEntidad}")
    public List<InformesResponse> globalXInmueble(@Valid @PathVariable("administradorId") int administradorId, @Valid @PathVariable("idEntidad") int idEntidad) {
        return informesService.informeXInmueble(administradorId, idEntidad);
    }

    @GetMapping("/inmueble/anio/{idInmueble}/{administradorId}")
    public List<InformesResponse> globalByInmuebleXAnio(
            @Valid @PathVariable("idInmueble") int id,
            @Valid @PathVariable("administradorId") int administradorId) {
        return informesService.informeByInmuebleXAnio(id, administradorId);
    }

    @GetMapping("/inmueble/mes/{idInmueble}/{anio}/{administradorId}")
    public List<InformesResponse> globalByInmuebleAnioXMes(
            @Valid @PathVariable("idInmueble") int id,
            @Valid @PathVariable("anio") int anio,
            @Valid @PathVariable("administradorId") int administradorId) {
        return informesService.informeByInmuebleAnioXMes(id, anio, administradorId);
    }

    @GetMapping("/anio/{administradorId}")
    public List<InformesResponse> globalXAnio(@Valid @PathVariable("administradorId") int administradorId) {
        return informesService.informeXAnio(administradorId);
    }

    @GetMapping("/anio/mes/{administradorId}/{anio}")
    public List<InformesResponse> globalByAnioXMes(@Valid @PathVariable("administradorId") int administradorId,
                                                   @Valid @PathVariable("anio") int anio) {
        return informesService.informeByAnioXMeses(administradorId, anio);
    }

    @GetMapping("/anio/inmueble/{administradorId}/{anio}/{mes}")
    public List<InformesResponse> globalByAnioMesXInmueble(
            @Valid @PathVariable("administradorId") int administradorId,
            @Valid @PathVariable("anio") int anio,
            @Valid @PathVariable("mes") int mes) {
        return informesService.informeByAnioMesesXInmuebles(administradorId, anio, mes);
    }



}
