package com.app.GestionInmuebles.Controller;


import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaDTO;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaResponse;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesResponse;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosResponse;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosResponse;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.Tipos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/tipos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TiposController {

    //-------------------------------------------Variable Service del controller de Inmuebles----------------------------------------------

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

    @Autowired
    @Qualifier("TipoCategoriaServiceImpl")
    private TipoCategoriaServiceImpl tipoCategoriaService;

    @Autowired
    @Qualifier("PagosServiceImpl")
    private PagosServiceImpl pagosService;

    //-------------------------------------------Metodos del controller de Inmuebles-------------------------------------------------------


    //###########################################Contratos#######################################################

    @PostMapping("/contrato")
    public ContratosResponse createTiposContrato(@RequestBody ContratosDTO tiposContratoDTO) {
        return contratosService.createUpdateTiposContrato(tiposContratoDTO);
    }

    @GetMapping("/contrato/{id}")
    public List<ContratosResponse> listTiposContratosadminstradorId(@PathVariable("id") int id) {
        return contratosService.listarTiposContratoadministradorId(id);
    }

    @GetMapping("/contrato/detalle/{id}")
    public List<ContratosResponse> listTiposContratosIdTipoContrato(@PathVariable("id") int id) {
        return contratosService.listarTiposContratoidContrato(id);
    }

    @PutMapping("/contrato")
    public ContratosResponse updateTiposContrato(@RequestBody ContratosDTO tiposContratoDTO) {
        return contratosService.createUpdateTiposContrato(tiposContratoDTO);
    }

    //###########################################Intervinientes#######################################################

    @PostMapping("/interviniente")
    public IntervinientesResponse createTiposIntervinientes(@RequestBody IntervinientesDTO tipoIntervinienteDTO) {
        return intervinientesService.createUpdateTipoIntervinientes(tipoIntervinienteDTO);
    }

    @GetMapping("/interviniente/{id}")
    public List<IntervinientesResponse> listTiposIntervininetesadminstradorId(@PathVariable("id") int id) {
        return intervinientesService.listTipoIntervinientesadministradorId(id);
    }

    @GetMapping("/interviniente/detalle/{id}")
    public List<IntervinientesResponse> listTiposIntervininetesIdTipoIntervinientes(@PathVariable("id") int id) {
        return intervinientesService.listTipoIntervinientesidIntervinientes(id);
    }

    @PutMapping("/interviniente")
    public IntervinientesResponse updateTiposIntervinientes(@RequestBody IntervinientesDTO tipoIntervinienteDTO) {
        return intervinientesService.createUpdateTipoIntervinientes(tipoIntervinienteDTO);
    }

//###########################################Periodos#######################################################

    @PostMapping("/periodo")
    public PeriodosResponse createTiposPeriodos(@RequestBody PeriodosDTO tipoPeriodosDTO) {
        return periodosService.createUpdatePeriodos(tipoPeriodosDTO);
    }

    @GetMapping("/periodo/{id}")
    public List<PeriodosResponse> listTiposPeriodosadminstradorId(@PathVariable("id") int id) {
        return periodosService.listarPeriodosadministradorId(id);
    }

    @GetMapping("/periodo/detalle/{id}")
    public List<PeriodosResponse> listTiposPeriodosIdTipoPeriodos(@PathVariable("id") int id) {
        return periodosService.listarPeriodosidPeriodos(id);
    }

    @PutMapping("/periodo")
    public PeriodosResponse updateTiposPeriodos(@RequestBody PeriodosDTO tipoPeriodosDTO) {
        return periodosService.createUpdatePeriodos(tipoPeriodosDTO);
    }

//###########################################Inmueble#######################################################

    @PostMapping("/inmueble")
    public TipoInmuebleResponse createTipoInmueble(@RequestBody TipoInmuebleDTO tipoInmuebleDTO) {
        return tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
    }

    @GetMapping("/inmueble/{id}")
    public List<TipoInmuebleResponse> listTipoInmuebleadminstradorId(@PathVariable("id") int id) {
        return tipoInmuebleService.listTipoInmuebleadministradorId(id);
    }

    @GetMapping("/inmueble/detalle/{id}")
    public List<TipoInmuebleResponse> listTipoInmuebleIdTipoInmueble(@PathVariable("id") int id) {
        return tipoInmuebleService.listTipoInmuebleidInmuebles(id);
    }

    @GetMapping("/inmueble/categoria/{idCategoria}/{id}")
    public List<TipoInmuebleResponse> listarTipoInmuebleAdministradorIdCategoriaId(@PathVariable("id") int id, @PathVariable("idCategoria") int idCategoria) {
        return tipoInmuebleService.listTipoInmuebleidInmueblesByCategoria(id, idCategoria);
    }

    @PutMapping("/inmueble")
    public TipoInmuebleResponse updateTipoInmueble(@RequestBody TipoInmuebleDTO tipoInmuebleDTO) {
        return tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
    }

//###########################################Rol#######################################################

    @PostMapping("/rol")
    public RolesResponse crearRol(@RequestBody RolesDTO rolesDTO) {
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }

    @GetMapping("/rol/{id}")
    public List<RolesResponse> listarRolesadministradorId(@PathVariable("id") int id) {
        return rolesServiceImpl.listarRolesadministradorId(id);
    }

    @GetMapping("rol/detalle/{id}")
    public List<RolesResponse> listarRolesIdRoles(@PathVariable("id") int id) {
        return rolesServiceImpl.listarRolesidRoles(id);
    }

    @PutMapping("/rol")
    public RolesResponse updateRoles(@RequestBody RolesDTO rolesDTO) {
        return rolesServiceImpl.createUpdateRoles(rolesDTO);
    }

//###########################################Concepto#######################################################

    @PostMapping("/concepto")
    public TipoConceptoResponse crearTipoConcepto(@RequestBody TipoConceptoDTO tipoConceptoDTO) {
        return tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
    }

    @GetMapping("/concepto/{id}")
    public List<TipoConceptoResponse> listarTipoConceptoAdministradorId(@PathVariable("id") int id) {
        return tipoConceptoService.listarTiposConceptoAdministradorId(id);
    }

    @GetMapping("/concepto/categoria/{idCategoria}/{id}")
    public List<TipoConceptoResponse> listarTipoConceptoAdministradorIdCategoriaId(@PathVariable("id") int id, @PathVariable("idCategoria") int idCategoria) {
        return tipoConceptoService.listarTiposConceptoAdministradorIdConceptoId(id, idCategoria);
    }

    @GetMapping("concepto/detalle/{id}")
    public List<TipoConceptoResponse> listarTipoConceptoId(@PathVariable("id") int id) {
        return tipoConceptoService.listarTiposConceptoId(id);
    }

    @PutMapping("/concepto")
    public TipoConceptoResponse updateTipoConcepto(@RequestBody TipoConceptoDTO tipoConceptoDTO) {
        return tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
    }

//###########################################Pagos#######################################################

    @PostMapping("/pago")
    public PagosResponse crearTipoPagos(@RequestBody PagosDTO pagosDTO) {
        return pagosService.createUpdatePagos(pagosDTO);
    }

    @GetMapping("/pago/{id}")
    public List<PagosResponse> listarTipoPagosAdministradorId(@PathVariable("id") int id) {
        return pagosService.listarPagosIdAdministrador(id);
    }

    @GetMapping("pago/detalle/{id}")
    public List<PagosResponse> listarTipoPagosId(@PathVariable("id") int id) {
        return pagosService.listarPagosIdPagos(id);
    }

    @PutMapping("/pago")
    public PagosResponse updateTipoPagos(@RequestBody PagosDTO pagosDTO) {
        return pagosService.createUpdatePagos(pagosDTO);
    }

    //###########################################Categoria#######################################################

    @PostMapping("/categoria")
    public TipoCategoriaResponse crearTipoCategoria(@RequestBody TipoCategoriaDTO tipoConceptoDTO) {
        return tipoCategoriaService.createUpdateCategoria(tipoConceptoDTO);
    }

    @GetMapping("/categoria/{id}")
    public List<TipoCategoriaResponse> listarTipoCategoria(@PathVariable("id") int id) {
        return tipoCategoriaService.listarCategoriaAdministradorId(id);
    }

    @GetMapping("/categoria/inmueble")
    public List<TipoCategoriaResponse> listarTipoCategoriaInmueble() {
        return tipoCategoriaService.listarCategoriaInmueble();
    }

    @GetMapping("/categoria/concepto")
    public List<TipoCategoriaResponse> listarTipoCategoriaConcepto() {
        return tipoCategoriaService.ListarCategoriaConcepto();
    }

    @GetMapping("categoria/detalle/{id}")
    public List<TipoCategoriaResponse> listarTipoCategoriaId(@PathVariable("id") int id) {
        return tipoCategoriaService.listarCategoriaIdCategoria(id);
    }

    @PutMapping("/categoria")
    public TipoCategoriaResponse updateTipoCategoria(@RequestBody TipoCategoriaDTO tipoConceptoDTO) {
        return tipoCategoriaService.createUpdateCategoria(tipoConceptoDTO);
    }

}
