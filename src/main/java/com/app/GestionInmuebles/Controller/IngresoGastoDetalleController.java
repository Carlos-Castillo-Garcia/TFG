package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.IngresoGastoDetalleServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.IngresoGastoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ingresogastodetalle")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IngresoGastoDetalleController {

    //-------------------------------------------Variable Service del controller de IngresoGasto----------------------------------------------
    @Autowired
    @Qualifier("IngresoGastoDetalleServiceImpl")
    private IngresoGastoDetalleServiceImpl ingresoGastoDetalleService;

    //-------------------------------------------Metodos del controller de IngresoGasto-------------------------------------------------------

    @Operation(
            summary = "Creado de Ingreso Gasto",
            description = "Metodo para la creacion de Ingreso Gasto",
            method = "POST"
    )
    @PostMapping
    public IngresoGastoDetalleResponse createContratos(
            @Parameter(
                    name = "Ingreso Gasto",
                    description = "Objeto de tipo Ingreso Gasto para la creacion del registro",
                    required = true
            )
            @Valid @RequestBody IngresoGastoDetalleDTO ingresoGastoDetalleDTO) {
        return ingresoGastoDetalleService.createUpdateIngresoGastoDetalle(ingresoGastoDetalleDTO);
    }

    @Operation(
            summary = "Modificacion de Ingreso Gasto",
            description = "Metodo para la modificacion de Ingreso Gasto",
            method = "PUT"
    )
    @PutMapping
    public IngresoGastoDetalleResponse updateContratos(
            @Parameter(
                    name = "Ingreso Gasto",
                    description = "Objeto de tipo Ingreso Gasto para la modificacion del registro",
                    required = true
            )
            @Valid @RequestBody IngresoGastoDetalleDTO ingresoGastoDetalleDTO) {
        return ingresoGastoDetalleService.createUpdateIngresoGastoDetalle(ingresoGastoDetalleDTO);
    }

    @Operation(
            summary = "Listado de Ingreso Gasto",
            description = "Metodo para la obtencion de Ingreso Gasto con filtrado del id de Inmueble",
            method = "GET"
    )
    @GetMapping("/{id}")
    public List<IngresoGastoDetalleResponse> listContratosInmuebleId(
            @Parameter(
                    name = "Id del Inmueble",
                    description = "Id Inmueble asociado al Contrato para su posterior uso en el filtrado",
                    required = true
            )
            @Valid @PathVariable("id") int id) {
        return ingresoGastoDetalleService.listarIngresoGastoDetalleAdministradorId(id);
    }

    @Operation(
            summary = "Listado de Ingreso Gasto",
            description = "Metodo para la obtencion del Ingreso Gasto",
            method = "GET"
    )
    @GetMapping("/detalles/{id}")
    public List<IngresoGastoDetalleResponse> listContratosIdIngresoGasto(
            @Parameter(
                    name = "Id del  Ingreso Gasto",
                    description = "Id  Ingreso Gasto para su posterior uso en el filtrado",
                    required = true
            )
            @Valid @PathVariable("id") int id) {
        return ingresoGastoDetalleService.listarIngresoGastoDetalleId(id);
    }

}
