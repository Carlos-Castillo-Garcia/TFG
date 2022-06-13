package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.IngresoGastoDetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/ingresogastodetalle")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IngresoGastoDetalleController {

    //-------------------------------------------Variable Service del controller de IngresoGasto----------------------------------------------
    @Autowired
    @Qualifier("IngresoGastoDetalleServiceImpl")
    private IngresoGastoDetalleServiceImpl ingresoGastoDetalleService;

    //-------------------------------------------Metodos del controller de IngresoGasto-------------------------------------------------------

    @PostMapping
    public IngresoGastoDetalleResponse createIngresoGastoDetalle(
             @RequestBody IngresoGastoDetalleDTO ingresoGastoDetalleDTO) {
        return ingresoGastoDetalleService.createUpdateIngresoGastoDetalle(ingresoGastoDetalleDTO);
    }

    @PutMapping
    public IngresoGastoDetalleResponse updateIngresoGastoDetalle(
             @RequestBody IngresoGastoDetalleDTO ingresoGastoDetalleDTO) {
        return ingresoGastoDetalleService.createUpdateIngresoGastoDetalle(ingresoGastoDetalleDTO);
    }

    @GetMapping("/{id}")
    public List<IngresoGastoDetalleResponse> listIngresoGastoDetalleInmuebleId(
             @PathVariable("id") int id) {
        return ingresoGastoDetalleService.listarIngresoGastoDetalleAdministradorId(id);
    }

    @GetMapping("/detalle/{id}")
    public List<IngresoGastoDetalleResponse> listIngresoGastoDetalleIdIngresoGasto(
             @PathVariable("id") int id) {
        return ingresoGastoDetalleService.listarIngresoGastoDetalleId(id);
    }
}
