package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteDTO;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteResponse;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosDTO;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosResponse;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.TipoIntervinienteServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.TipoPeriodoServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.TiposContratoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Tipos")
public class TiposController {

    @Autowired
    @Qualifier("TiposContratoServiceImpl")
    private TiposContratoServiceImpl tiposContratoService;

    @Autowired
    @Qualifier("TipoIntervinienteServiceImpl")
    private TipoIntervinienteServiceImpl tipoIntervinienteService;

    @Autowired
    @Qualifier("TipoPeriodoServiceImpl")
    private TipoPeriodoServiceImpl tipoPeriodoService;


    @PostMapping("/Contratos")
    public TiposContratoResponse createTiposContrato(@Valid @RequestBody TiposContratoDTO tiposContratoDTO){
        return tiposContratoService.createUpdateTiposContrato(tiposContratoDTO);
    }

    @GetMapping("/Contratos")
    public List<TiposContratoResponse> listTiposContratos(){
        return tiposContratoService.listarTiposContrato();
    }

    @PutMapping("/Contratos")
    public TiposContratoResponse updateTiposContrato(@Valid @RequestBody TiposContratoDTO tiposContratoDTO){
        return tiposContratoService.createUpdateTiposContrato(tiposContratoDTO);
    }

    @PostMapping("/Intervinientes")
    public TipoIntervinienteResponse createTiposIntervinientes(@Valid @RequestBody TipoIntervinienteDTO tipoIntervinienteDTO){
        return tipoIntervinienteService.createUpdateTipoInterviniente(tipoIntervinienteDTO);
    }

    @GetMapping("/Intervinientes")
    public List<TipoIntervinienteResponse> listTiposIntervininetes(){
        return tipoIntervinienteService.listTipoInterviniente();
    }

    @PutMapping("/Intervinientes")
    public TipoIntervinienteResponse updateTiposIntervinientes(@Valid @RequestBody TipoIntervinienteDTO tipoIntervinienteDTO){
        return tipoIntervinienteService.createUpdateTipoInterviniente(tipoIntervinienteDTO);
    }

    @PostMapping("/Periodo")
    public TipoPeriodosResponse createTiposPeriodos(@Valid @RequestBody TipoPeriodosDTO tipoPeriodosDTO){
        return tipoPeriodoService.createUpdateTipoPeriodo(tipoPeriodosDTO);
    }

    @GetMapping("/Periodo")
    public List<TipoPeriodosResponse> listTiposPeriodos(){
        return tipoPeriodoService.listarTiposPeriodos();
    }

    @PutMapping("/Periodo")
    public TipoPeriodosResponse updateTiposPeriodos(@Valid @RequestBody TipoPeriodosDTO tipoPeriodosDTO){
        return tipoPeriodoService.createUpdateTipoPeriodo(tipoPeriodosDTO);
    }
}
