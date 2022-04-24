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
import com.app.GestionInmuebles.Services.TipoIntervinienteService;
import com.app.GestionInmuebles.Services.TipoPeriodoService;
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
    public TiposContratoResponse crearTiposContrato(@Valid @RequestBody TiposContratoDTO tiposContratoDTO){
        return tiposContratoService.crearTipos(tiposContratoDTO);
    }

    @GetMapping("/Contratos")
    public List<TiposContratoResponse> listarTiposContratos(){
        return tiposContratoService.listarTipos();
    }

    @PostMapping("/Intervinietes")
    public TipoIntervinienteResponse crearTiposIntervinientes(@Valid @RequestBody TipoIntervinienteDTO tipoIntervinienteDTO){
        return tipoIntervinienteService.crearTipoInterviniente(tipoIntervinienteDTO);
    }

    @GetMapping("/Intervinientes")
    public List<TipoIntervinienteResponse> listarTiposIntervininetes(){
        return tipoIntervinienteService.listTipoInterviniente();
    }

    @PostMapping("/Periodo")
    public TipoPeriodosResponse crearTiposPeriodos(@Valid @RequestBody TipoPeriodosDTO tipoPeriodosDTO){
        return tipoPeriodoService.crearTipoPeriodo(tipoPeriodosDTO);
    }

    @GetMapping("/Periodo")
    public List<TipoPeriodosResponse> listarTiposPeriodos(){
        return tipoPeriodoService.listarTiposPeriodos();
    }
}
