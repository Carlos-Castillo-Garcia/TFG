package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.IngresoGastoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/ingresogasto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IngresoGastoController {

    //-------------------------------------------Variable Service del controller de IngresoGasto----------------------------------------------
    @Autowired
    @Qualifier("IngresoGastoServiceImpl")
    private IngresoGastoServiceImpl ingresoGastoService;

    //-------------------------------------------Metodos del controller de IngresoGasto-------------------------------------------------------

    @PostMapping
    public IngresoGastoResponse createIngresoGasto(
             @RequestBody IngresoGastoDTO ingresoGastoDTO) {
        return ingresoGastoService.createUpdateIgresoGasto(ingresoGastoDTO);
    }

    @PutMapping
    public IngresoGastoResponse updateIngresoGasto(
             @RequestBody  IngresoGastoDTO ingresoGastoDTO) {
        return ingresoGastoService.createUpdateIgresoGasto(ingresoGastoDTO);
    }

    @GetMapping("/{id}")
    public List<IngresoGastoResponse> listIngresoGastoInmuebleId(
             @PathVariable("id") int idAdministrador) {
        return ingresoGastoService.listarIngresoGasto(idAdministrador);
    }

    @GetMapping("/detalle/{id}")
    public List<IngresoGastoResponse> listIngresoGastoIdIngresoGasto(
             @PathVariable("id") int idInGa) {
        return ingresoGastoService.listarIngresoGastoId(idInGa);
    }

    @GetMapping("/{idAdministrador}/{entidad}")
    public List<IngresoGastoResponse> listIngresoGastoIdIngresoGasto(
             @PathVariable("idAdministrador") int idAdministrador,
             @PathVariable("entidad") int entidad) {
        return ingresoGastoService.listarIngresoGastoEntidad(idAdministrador, entidad);
    }

    @GetMapping("/anio/{id}")
    public List<String> listfechas(
             @PathVariable("id") int id) {
        return ingresoGastoService.listarfechas(id);
    }

    @GetMapping("/avisos/facturasinpagadas/{administradorId}/{clienteId}")
    public  List<IngresoGastoResponse> avisosFacturas( @PathVariable("administradorId") int id,  @PathVariable("clienteId") int clienteId){
        return ingresoGastoService.avisosFacturasAdministradorId(id, clienteId);
    }

}
