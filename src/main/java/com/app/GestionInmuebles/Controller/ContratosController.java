package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TBIContratosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("api/v1/contrato")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContratosController {

    //-------------------------------------------Variable Service del controller de Contratos----------------------------------------------
    @Autowired
    @Qualifier("TBIContratosServiceImpl")
    private TBIContratosServiceImpl tbiContratosService;

    //-------------------------------------------Metodos del controller de Contratos-------------------------------------------------------

    @PostMapping
    public TBIContratosResponse createContratos(
            @RequestBody TBIContratosDTO tbiContratosDTO) {
        return tbiContratosService.createUpdateContratos(tbiContratosDTO);
    }

    @PutMapping
    public TBIContratosResponse updateContratos(
            @RequestBody TBIContratosDTO tbiContratosDTO) {
        return tbiContratosService.createUpdateContratos(tbiContratosDTO);
    }

    @GetMapping("/{id}")
    public List<TBIContratosResponse> listContratosIdAdministrador(@PathVariable("id") int idAdministrador) {
        return tbiContratosService.listarContratosadministradorId(idAdministrador);
    }

    @GetMapping("/{administradorId}/{entidad}")
    public List<TBIContratosResponse> listContratosEntidad(@PathVariable("administradorId") int idAdministrador,
                                                           @PathVariable("entidad") int entidad) {
        return tbiContratosService.listarContratosPropietario(idAdministrador, entidad);
    }

    @GetMapping("/detalle/{id}")
    public List<TBIContratosResponse> listContratosIdContratos(@PathVariable("id") int idContrato) {
        return tbiContratosService.listarContratosidContratos(idContrato);
    }


}
