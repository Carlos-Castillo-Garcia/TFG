package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteDTO;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteResponse;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosDTO;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosResponse;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
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
    @Qualifier("TipoIntervinienteService")
    private TipoIntervinienteService tipoIntervinienteService;


    @Autowired
    @Qualifier("TipoPeriodoService")
    private TipoPeriodoService tipoPeriodoService;


    @PostMapping("/crearTipos")
    public TiposContratoResponse crearTiposContrato(@Valid @RequestBody TiposContratoDTO tiposContratoDTO){
        return tiposContratoService.crearTipos(tiposContratoDTO);
    }

    @GetMapping("/getTipos")
    public List<TiposContratoResponse> listarTiposContratos(){
        return tiposContratoService.listarTipos();
    }

    @PostMapping("/crearTipos")
    public TipoIntervinienteResponse crearTiposIntervinientes(@Valid @RequestBody TipoIntervinienteDTO tipoIntervinienteDTO){
        return tipoIntervinienteService.crearTipoInterviniente(tipoIntervinienteDTO);
    }

    @GetMapping("/getTipos")
    public List<TipoIntervinienteResponse> listarTiposIntervininetes(){
        return tipoIntervinienteService.listTipoInterviniente();
    }

    @PostMapping("/crearTipos")
    public TipoPeriodosResponse crearTiposPeriodos(@Valid @RequestBody TipoPeriodosDTO tipoPeriodosDTO){
        return tipoPeriodoService.crearTipoPeriodo(tipoPeriodosDTO);
    }

    @GetMapping("/getTipos")
    public List<TipoPeriodosResponse> listarTiposPeriodos(){
        return tipoPeriodoService.listarTiposPeriodos();
    }
}
