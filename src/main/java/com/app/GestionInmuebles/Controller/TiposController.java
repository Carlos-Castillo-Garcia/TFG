package com.app.GestionInmuebles.Controller;


import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesResponse;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosResponse;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.Tipos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TiposController {

    @Autowired
    @Qualifier("ContratosServiceImpl")
    private ContratosServiceImpl contratosService;

    @Autowired
    @Qualifier("IntervinientesServiceImpl")
    private IntervinientesServiceImpl intervinientesService;

    @Autowired
    @Qualifier("PeriodosServiceImpl")
    private PeriodosServiceImpl periodosService;

    @Autowired
    @Qualifier("TipoInmuebleServiceImpl")
    private TipoInmuebleServiceImpl tipoInmuebleService;

    @Autowired
    @Qualifier(value = "RolesServiceImpl")
    private RolesServiceImpl rolesServiceImpl;

    @Autowired
    @Qualifier("TipoConceptoServiceImpl")
    private TipoConceptoServiceImpl tipoConceptoService;


    @PostMapping("/contratos")
    public ContratosResponse createTiposContrato(@Valid @RequestBody ContratosDTO tiposContratoDTO){
        return contratosService.createUpdateTiposContrato(tiposContratoDTO);
    }

    @GetMapping("/contratos/{id}")
    public List<ContratosResponse> listTiposContratosadminstradorId(@Valid @PathVariable("id") int id){
        return contratosService.listarTiposContratoadministradorId(id);
    }

    @GetMapping("/contratos/detalle/{id}")
    public List<ContratosResponse> listTiposContratosIdTipoContrato(@Valid @PathVariable("id") int id){
        return contratosService.listarTiposContratoidContrato(id);
    }

    @PutMapping("/contratos")
    public ContratosResponse updateTiposContrato(@Valid @RequestBody ContratosDTO tiposContratoDTO){
        return contratosService.createUpdateTiposContrato(tiposContratoDTO);
    }



    @PostMapping("/intervinientes")
    public IntervinientesResponse createTiposIntervinientes(@Valid @RequestBody IntervinientesDTO tipoIntervinienteDTO){
        return intervinientesService.createUpdateTipoIntervinientes(tipoIntervinienteDTO);
    }

    @GetMapping("/intervinientes/{id}")
    public List<IntervinientesResponse> listTiposIntervininetesadminstradorId(@Valid @PathVariable("id") int id){
        return intervinientesService.listTipoIntervinientesadministradorId(id);
    }

    @GetMapping("/intervinientes/detalle/{id}")
    public List<IntervinientesResponse> listTiposIntervininetesIdTipoIntervinientes(@Valid @PathVariable("id") int id){
        return intervinientesService.listTipoIntervinientesidIntervinientes(id);
    }

    @PutMapping("/intervinientes")
    public IntervinientesResponse updateTiposIntervinientes(@Valid @RequestBody IntervinientesDTO tipoIntervinienteDTO){
        return intervinientesService.createUpdateTipoIntervinientes(tipoIntervinienteDTO);
    }



    @PostMapping("/periodos")
    public PeriodosResponse createTiposPeriodos(@Valid @RequestBody PeriodosDTO tipoPeriodosDTO){
        return periodosService.createUpdatePeriodos(tipoPeriodosDTO);
    }

    @GetMapping("/periodos/{id}")
    public List<PeriodosResponse> listTiposPeriodosadminstradorId(@Valid @PathVariable("id") int id){
        return periodosService.listarPeriodosadministradorId(id);
    }

    @GetMapping("/periodos/detalle/{id}")
    public List<PeriodosResponse> listTiposPeriodosIdTipoPeriodos(@Valid @PathVariable("id") int id){
        return periodosService.listarPeriodosidPeriodos(id);
    }

    @PutMapping("/periodos")
    public PeriodosResponse updateTiposPeriodos(@Valid @RequestBody PeriodosDTO tipoPeriodosDTO){
        return periodosService.createUpdatePeriodos(tipoPeriodosDTO);
    }



    @PostMapping("/inmuebles")
    public TipoInmuebleResponse createTipoInmueble(@Valid @RequestBody TipoInmuebleDTO tipoInmuebleDTO){
        return tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
    }

    @GetMapping("/inmuebles/{id}")
    public List<TipoInmuebleResponse> listTipoInmuebleadminstradorId(@Valid @PathVariable("id") int id){
        return tipoInmuebleService.listTipoInmuebleadministradorId(id);
    }

    @GetMapping("/inmuebles/detalle/{id}")
    public List<TipoInmuebleResponse> listTipoInmuebleIdTipoInmueble(@Valid @PathVariable("id") int id){
        return tipoInmuebleService.listTipoInmuebleidInmuebles(id);
    }

    @PutMapping("/inmuebles")
    public TipoInmuebleResponse updateTipoInmueble(@Valid @RequestBody TipoInmuebleDTO tipoInmuebleDTO){
        return tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
    }



    @PostMapping("/rol")
    public RolesResponse crearRol(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }

    @GetMapping("/rol/{id}")
    public List<RolesResponse> listarRolesadministradorId(@Valid @PathVariable("id") int id){
        return rolesServiceImpl.listarRolesadministradorId(id);
    }

    @GetMapping("rol/detalle/{id}")
    public List<RolesResponse> listarRolesIdRoles(@Valid @PathVariable("id") int id){
        return rolesServiceImpl.listarRolesidRoles(id);
    }

    @PutMapping("/rol")
    public RolesResponse updateRoles(@Valid @RequestBody RolesDTO rolesDTO){
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }



    @PostMapping("/concepto")
    public TipoConceptoResponse crearTipoConcepto(@Valid @RequestBody TipoConceptoDTO tipoConceptoDTO){
        return tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
    }

    @GetMapping("/concepto/{id}")
    public List<TipoConceptoResponse> listarTipoConceptoAdministradorId(@Valid @PathVariable("id") int id){
        return tipoConceptoService.listarTiposConceptoAdministradorId(id);
    }

    @GetMapping("concepto/detalle/{id}")
    public List<TipoConceptoResponse> listarTipoConceptoId(@Valid @PathVariable("id") int id){
        return tipoConceptoService.listarTiposConceptoId(id);
    }

    @PutMapping("/concepto")
    public TipoConceptoResponse updateTipoConcepto(@Valid @RequestBody TipoConceptoDTO tipoConceptoDTO){
        return tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
    }

}
