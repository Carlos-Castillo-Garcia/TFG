package com.app.GestionInmuebles.Services.ServiceImpl.Inicio;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesDTO;
import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import com.app.GestionInmuebles.Services.ServiceImpl.Tipos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InicializacionTipos implements ApplicationRunner {

    @Autowired
    @Qualifier("RolesServiceImpl")
    private RolesServiceImpl rolesService;

    @Autowired
    @Qualifier("TipoInmuebleServiceImpl")
    private TipoInmuebleServiceImpl tipoInmuebleService;

    @Autowired
    @Qualifier("TipoConceptoServiceImpl")
    private TipoConceptoServiceImpl tipoConceptoService;

    @Autowired
    @Qualifier("PeriodosServiceImpl")
    private PeriodosServiceImpl periodosService;

    @Autowired
    @Qualifier("IntervinientesServiceImpl")
    private IntervinientesServiceImpl intervinientesService;

    @Autowired
    @Qualifier("ContratosServiceImpl")
    private ContratosServiceImpl contratosService;

    @Autowired
    @Qualifier("PagosServiceImpl")
    private PagosServiceImpl pagosService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.roles();
        this.tipoPeriodos();
        this.tipoIntervinientes();
        this.tipoContratos();
        this.tiposInmuebles();
        this.tipoConcepto();
        this.tipoPagos();
    }

    public void roles(){
        List<String> nombreRoles = new ArrayList<>();
        nombreRoles.add("administrador");
        nombreRoles.add("gestor");
        nombreRoles.add("inquilino");
        nombreRoles.add("propietario");
        nombreRoles.add("visitante");
        RolesDTO rolesDTO = new RolesDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(rolesService.listarRolesadministradorId(0).size() == 0){
            for (String nombreRol : nombreRoles) {
                rolesDTO.setNombreRol(nombreRol);
                rolesService.createUpdateRoles(rolesDTO);
            }
        }
    }

    public void tipoPeriodos(){
        List<String> periodos = new ArrayList<>();
        periodos.add("año");
        periodos.add("mes");
        PeriodosDTO periodosDTO = new PeriodosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(periodosService.listarPeriodosadministradorId(0).size() == 0){
            for (String periodo : periodos) {
                periodosDTO.setTipoPeriodo(periodo);
                periodosService.createUpdatePeriodos(periodosDTO);
            }
        }
    }

    public void tipoPagos(){
        List<String> pagos = new ArrayList<>();
        pagos.add("efectivo");
        pagos.add("cuenta corriente");
        pagos.add("tarjeta credito");
        pagos.add("aplazado");
        PagosDTO pagosDTO = new PagosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(pagosService.listarPagosIdAdministrador(0).size() == 0){
            for (String pago : pagos) {
                pagosDTO.setTipoPagos(pago);
                pagosService.createUpdatePagos(pagosDTO);
            }
        }
    }

    public void tipoIntervinientes(){
        List<String> tipoInterviniente = new ArrayList<>();
        tipoInterviniente.add("comprador");
        tipoInterviniente.add("vendedor");
        tipoInterviniente.add("arredador");
        tipoInterviniente.add("arrendatario");
        tipoInterviniente.add("avalista");
        IntervinientesDTO intervinientesDTO = new IntervinientesDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(intervinientesService.listTipoIntervinientesadministradorId(0).size() == 0){
            for (String interviniente : tipoInterviniente) {
                intervinientesDTO.setTipoInterviniente(interviniente);
                intervinientesService.createUpdateTipoIntervinientes(intervinientesDTO);
            }
        }
    }

    public void tipoContratos(){
        List<String> contratos = new ArrayList<>();
        contratos.add("alquiler");
        contratos.add("compraventa");
        contratos.add("servicios");
        ContratosDTO contratosDTO = new ContratosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(contratosService.listarTiposContratoadministradorId(0).size() == 0){
            for (String contrato : contratos) {
                contratosDTO.setTipoContrato(contrato);
                contratosService.createUpdateTiposContrato(contratosDTO);
            }
        }
    }

    public void tiposInmuebles(){
        List<String> tipoInmuebleViviendas = new ArrayList<>();
        List<String> tipoInmuebleIndustria = new ArrayList<>();
        List<String> tipoInmuebleSuelo = new ArrayList<>();
        tipoInmuebleViviendas.add("casa");
        tipoInmuebleViviendas.add("piso");
        tipoInmuebleViviendas.add("apartamento");
        tipoInmuebleViviendas.add("chalet");
        tipoInmuebleViviendas.add("loft");
        tipoInmuebleViviendas.add("atico");

        tipoInmuebleIndustria.add("nave");
        tipoInmuebleIndustria.add("local");
        tipoInmuebleIndustria.add("oficina");

        tipoInmuebleSuelo.add("parcela");
        tipoInmuebleSuelo.add("solar");

        TipoInmuebleDTO tipoInmuebleDTO = new TipoInmuebleDTO(0, "", "", false, new Date(), new Date(), 0, 0);
        if (tipoInmuebleService.listTipoInmuebleadministradorId(0).size() == 0){
            for (String tipoInmueble: tipoInmuebleViviendas) {
                tipoInmuebleDTO.setTipoInmueble("viviendas");
                tipoInmuebleDTO.setTipoEspecifico(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
            for (String tipoInmueble: tipoInmuebleIndustria) {
                tipoInmuebleDTO.setTipoInmueble("industria");
                tipoInmuebleDTO.setTipoEspecifico(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
            for (String tipoInmueble: tipoInmuebleSuelo) {
                tipoInmuebleDTO.setTipoInmueble("suelo");
                tipoInmuebleDTO.setTipoEspecifico(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
        }
    }

    public void tipoConcepto(){
        List<String> tipoConceptoSuministros = new ArrayList<>();
        List<String> tipoConceptoReformas = new ArrayList<>();
        List<String> tipoConceptoMobiliario = new ArrayList<>();
        tipoConceptoSuministros.add("agua");
        tipoConceptoSuministros.add("luz");
        tipoConceptoSuministros.add("gas");
        tipoConceptoSuministros.add("comunicaciones");
        tipoConceptoSuministros.add("comunidades");

        tipoConceptoReformas.add("mano obra");
        tipoConceptoReformas.add("albañileria");
        tipoConceptoReformas.add("electricidad");
        tipoConceptoReformas.add("fontaneria");
        tipoConceptoReformas.add("cerramientos");

        tipoConceptoMobiliario.add("electrodomesticos");
        tipoConceptoMobiliario.add("cocina");
        tipoConceptoMobiliario.add("baños");
        tipoConceptoMobiliario.add("dormitorios");
        tipoConceptoMobiliario.add("salon");

        TipoConceptoDTO tipoConceptoDTO = new TipoConceptoDTO(0, "", "", false, new Date(), new Date(), 0, 0);
        if (tipoConceptoService.listarTiposConceptoAdministradorId(0).size() == 0){
            for (String tipoConcepto: tipoConceptoSuministros) {
                tipoConceptoDTO.setTipoConcepto("Suministros");
                tipoConceptoDTO.setTipoEspecifico(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoReformas) {
                tipoConceptoDTO.setTipoConcepto("Reformas");
                tipoConceptoDTO.setTipoEspecifico(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoMobiliario) {
                tipoConceptoDTO.setTipoConcepto("Mobiliario");
                tipoConceptoDTO.setTipoEspecifico(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
        }
    }
}
