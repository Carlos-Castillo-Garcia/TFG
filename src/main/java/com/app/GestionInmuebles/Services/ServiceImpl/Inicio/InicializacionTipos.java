package com.app.GestionInmuebles.Services.ServiceImpl.Inicio;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
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

/**
 * Clase para la Auto Generacion de Registros al inicio de la aplicacion
 * @author Carlos Castillo
 */
@Component
public class InicializacionTipos implements ApplicationRunner {

    //-------------------------------------------Variable Service de la inicializacion de Tipos----------------------------------------------
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

    @Autowired
    @Qualifier("TipoCategoriaServiceImpl")
    private TipoCategoriaServiceImpl tipoCategoriaService;

    //-------------------------------------------Metodos de la Clase Inicializacion Tipos-------------------------------------------------------

    /**
     * Metodo para la ejecucion del resto de los metodos de la inicializacion de tipos
     * @param args parametro necesario para la ejecucion del metodo
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.roles();
        this.tipoPeriodos();
        this.tipoIntervinientes();
        this.tipoContratos();
        this.tipoCategoria();
        this.tiposInmuebles();
        this.tipoConcepto();
        this.tipoPagos();
    }

    /**
     * Inicializacion de Roles
     */
    public void roles(){
        List<String> nombreRoles = new ArrayList<>();
        nombreRoles.add("Administrador");
        nombreRoles.add("Gestor");
        nombreRoles.add("Propietario");
        RolesDTO rolesDTO = new RolesDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(rolesService.listarRolesadministradorId(0).size() == 0){
            for (String nombreRol : nombreRoles) {
                rolesDTO.setNombreRol(nombreRol);
                rolesService.createUpdateRoles(rolesDTO);
            }
        }
    }

    /**
     * Inicializacion de Periodos
     */
    public void tipoPeriodos(){
        List<String> periodos = new ArrayList<>();
        periodos.add("Año");
        periodos.add("Mes");
        periodos.add("Unico");
        PeriodosDTO periodosDTO = new PeriodosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(periodosService.listarPeriodosadministradorId(0).size() == 0){
            for (String periodo : periodos) {
                periodosDTO.setTipoPeriodo(periodo);
                periodosService.createUpdatePeriodos(periodosDTO);
            }
        }
    }

    /**
     * Inicializacion de Pagos
     */
    public void tipoPagos(){
        List<String> pagos = new ArrayList<>();
        pagos.add("Efectivo");
        pagos.add("Cuenta Corriente");
        pagos.add("Tarjeta Credito");
        pagos.add("Aplazado");
        PagosDTO pagosDTO = new PagosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(pagosService.listarPagosIdAdministrador(0).size() == 0){
            for (String pago : pagos) {
                pagosDTO.setTipoPagos(pago);
                pagosService.createUpdatePagos(pagosDTO);
            }
        }
    }

    /**
     * Inicializacion de Intervinientes
     */
    public void tipoIntervinientes(){
        List<String> tipoInterviniente = new ArrayList<>();
        tipoInterviniente.add("Comprador");
        tipoInterviniente.add("Vendedor");
        tipoInterviniente.add("Arrendador");
        tipoInterviniente.add("Arrendatario");
        tipoInterviniente.add("Avalista");
        IntervinientesDTO intervinientesDTO = new IntervinientesDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(intervinientesService.listTipoIntervinientesadministradorId(0).size() == 0){
            for (String interviniente : tipoInterviniente) {
                intervinientesDTO.setTipoInterviniente(interviniente);
                intervinientesService.createUpdateTipoIntervinientes(intervinientesDTO);
            }
        }
    }

    /**
     * Inicializacion de Contratos
     */
    public void tipoContratos(){
        List<String> contratos = new ArrayList<>();
        contratos.add("Alquiler");
        contratos.add("Compraventa");
        contratos.add("Servicios");
        ContratosDTO contratosDTO = new ContratosDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(contratosService.listarTiposContratoadministradorId(0).size() == 0){
            for (String contrato : contratos) {
                contratosDTO.setTipoContrato(contrato);
                contratosService.createUpdateTiposContrato(contratosDTO);
            }
        }
    }

    /**
     * Inicializacion de Categorias
     */
    public void tipoCategoria(){
        List<String> categoria = new ArrayList<>();
        categoria.add("Vivinedas");
        categoria.add("Industria");
        categoria.add("Suelo");
        categoria.add("Suministros");
        categoria.add("Reformas");
        categoria.add("Mobiliario");
        categoria.add("Alquiler");
        categoria.add("Compra");
        TipoCategoriaDTO tipoCategoriaDTO = new TipoCategoriaDTO(0, "", false, new Date(), new Date(), 0, 0);
        if(tipoCategoriaService.listarCategoriaAdministradorId(0).size() == 0){
            for (String nombreCategoria : categoria) {
                tipoCategoriaDTO.setCategoria(nombreCategoria);
                tipoCategoriaService.createUpdateCategoria(tipoCategoriaDTO);
            }
        }
    }

    /**
     * Inicializacion de Inmuebles
     */
    public void tiposInmuebles(){
        List<String> tipoInmuebleViviendas = new ArrayList<>();
        List<String> tipoInmuebleIndustria = new ArrayList<>();
        List<String> tipoInmuebleSuelo = new ArrayList<>();
        tipoInmuebleViviendas.add("Casa");
        tipoInmuebleViviendas.add("Piso");
        tipoInmuebleViviendas.add("Apartamento");
        tipoInmuebleViviendas.add("Chalet");
        tipoInmuebleViviendas.add("Loft");
        tipoInmuebleViviendas.add("Atico");

        tipoInmuebleIndustria.add("Nave");
        tipoInmuebleIndustria.add("Local");
        tipoInmuebleIndustria.add("Oficina");

        tipoInmuebleSuelo.add("Parcela");
        tipoInmuebleSuelo.add("Solar");

        TipoInmuebleDTO tipoInmuebleDTO = new TipoInmuebleDTO(0, "", 0, false, new Date(), new Date(), 0, 0);
        if (tipoInmuebleService.listTipoInmuebleadministradorId(0).size() == 0){
            for (String tipoInmueble: tipoInmuebleViviendas) {
                tipoInmuebleDTO.setCategoriaId(1);
                tipoInmuebleDTO.setTipoInmueble(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
            for (String tipoInmueble: tipoInmuebleIndustria) {
                tipoInmuebleDTO.setCategoriaId(2);
                tipoInmuebleDTO.setTipoInmueble(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
            for (String tipoInmueble: tipoInmuebleSuelo) {
                tipoInmuebleDTO.setCategoriaId(3);
                tipoInmuebleDTO.setTipoInmueble(tipoInmueble);
                tipoInmuebleService.createUpdateTipoInmueble(tipoInmuebleDTO);
            }
        }
    }

    /**
     * Inicializacion de Conceptos
     */
    public void tipoConcepto(){
        List<String> tipoConceptoSuministros = new ArrayList<>();
        List<String> tipoConceptoReformas = new ArrayList<>();
        List<String> tipoConceptoMobiliario = new ArrayList<>();
        List<String> tipoConceptoAlquiler = new ArrayList<>();
        List<String> tipoConceptoCompraVenta = new ArrayList<>();
        tipoConceptoSuministros.add("Agua");
        tipoConceptoSuministros.add("Luz");
        tipoConceptoSuministros.add("Gas");
        tipoConceptoSuministros.add("Comunicaciones");
        tipoConceptoSuministros.add("Comunidades");

        tipoConceptoReformas.add("Mano Obra");
        tipoConceptoReformas.add("Albañileria");
        tipoConceptoReformas.add("Electricidad");
        tipoConceptoReformas.add("Fontaneria");
        tipoConceptoReformas.add("Cerramientos");

        tipoConceptoMobiliario.add("Electrodomesticos");
        tipoConceptoMobiliario.add("Cocina");
        tipoConceptoMobiliario.add("Baños");
        tipoConceptoMobiliario.add("Dormitorios");
        tipoConceptoMobiliario.add("Salon");

        tipoConceptoAlquiler.add("Alquiler");
        tipoConceptoAlquiler.add("Fianza");

        tipoConceptoCompraVenta.add("Compra");
        tipoConceptoCompraVenta.add("Venta");
        tipoConceptoCompraVenta.add("Arras");

        TipoConceptoDTO tipoConceptoDTO = new TipoConceptoDTO(0, "", 0, false, new Date(), new Date(), 0, 0);
        if (tipoConceptoService.listarTiposConceptoAdministradorId(0).size() == 0){
            for (String tipoConcepto: tipoConceptoSuministros) {
                tipoConceptoDTO.setCategoriaId(4);
                tipoConceptoDTO.setTipoConcepto(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoReformas) {
                tipoConceptoDTO.setCategoriaId(5);
                tipoConceptoDTO.setTipoConcepto(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoMobiliario) {
                tipoConceptoDTO.setCategoriaId(6);
                tipoConceptoDTO.setTipoConcepto(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoAlquiler) {
                tipoConceptoDTO.setCategoriaId(7);
                tipoConceptoDTO.setTipoConcepto(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
            for (String tipoConcepto: tipoConceptoCompraVenta) {
                tipoConceptoDTO.setCategoriaId(8);
                tipoConceptoDTO.setTipoConcepto(tipoConcepto);
                tipoConceptoService.createUpdateTiposConcepto(tipoConceptoDTO);
            }
        }
    }
}
