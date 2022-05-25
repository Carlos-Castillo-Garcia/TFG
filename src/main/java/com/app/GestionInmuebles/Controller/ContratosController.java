package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TBIContratosServiceImpl;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Operation(
            summary = "Creado de Contratos",
            description = "Metodo para la creacion de Contratos",
            method = "POST"
    )
    @PostMapping
    public TBIContratosResponse createContratos(
            @Parameter(
                    name = "Contrato",
                    description = "Objeto de tipo contrato para la creacion del registro",
                    required = true
            )
            @Valid @RequestBody TBIContratosDTO tbiContratosDTO) {
        return tbiContratosService.createUpdateContratos(tbiContratosDTO);
    }

    @Operation(
            summary = "Modificacion de Contratos",
            description = "Metodo para la modificacion de Contratos",
            method = "PUT"
    )
    @PutMapping
    public TBIContratosResponse updateContratos(
            @Parameter(
                    name = "Contratos",
                    description = "Objeto de tipo contrato para la modificacion del registro",
                    required = true
            )
            @Valid @RequestBody TBIContratosDTO tbiContratosDTO) {
        return tbiContratosService.createUpdateContratos(tbiContratosDTO);
    }

    @GetMapping("/{id}")
    public List<TBIContratosResponse> listContratosIdAdministrador(@Valid @PathVariable("id") int id){
        return tbiContratosService.listarContratosadministradorId(id);
    }

    @Operation(
            summary = "Listado de Contrato",
            description = "Metodo para la obtencion del Contrato",
            method = "GET"
    )
    @GetMapping("/detalle/{id}")
    public List<TBIContratosResponse> listContratosIdContratos(@Valid @PathVariable("id") int id) {
        return tbiContratosService.listarContratosidContratos(id);
    }


}
