package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.IngresoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("IngresoGastoServiceImpl")
public class IngresoGastoServiceImpl implements IngresoGastoService {

    //-------------------------------------------Variable Service de Ingreso Gasto Repository----------------------------------------------
    @Autowired
    @Qualifier("IngresoGastoRepository")
    private IngresoGastoRepository ingresoGastoRepository;

    //-------------------------------------------Metodos de la Clase Ingreso Gasto Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de IngresoGastoResponse
     */
    @Override
    public List<IngresoGastoResponse> listarIngresoGasto(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByAdministradorIdOrderByFechaFacturaDesc(id)) {
            if (!i.isBorrado()) {
                ingresoGastoResponseList.add(EntityToResponse(i));
            }
        }
        return ingresoGastoResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de IngresoGastoResponse
     */
    @Override
    public List<IngresoGastoResponse> listarIngresoGastoId(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByIdInGa(id)) {
            ingresoGastoResponseList.add(EntityToResponse(i));
        }
        return ingresoGastoResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por el administrador y la entidad
     * @param entidad parametro necesario para la ejecucion del metodo
     * @return Lista de IngresoGastoResponse
     */
    @Override
    public List<IngresoGastoResponse> listarIngresoGastoEntidad(int idAdministrador, int entidad) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByEntidadOrderByFecha(idAdministrador, entidad)) {
            ingresoGastoResponseList.add(EntityToResponse(i));
        }
        return ingresoGastoResponseList;
    }

    /**
     * Metodo para la obtencion de un listado de fechas de las facturas filtradas por el administrador
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de String
     */
    @Override
    public List<String> listarfechas(int id) {
        List<String> listaFechas = new ArrayList<>();
        List<IngresoGastoEntity> ingresoGastoEntityList = ingresoGastoRepository.obtencionFecha(id);
        for (int i = 0; i < ingresoGastoEntityList.size(); i++) {
            if (listaFechas.size() == 0) {
                listaFechas.add(ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0, 4));
            }
            for (int j = listaFechas.size(); j != 0; j--) {
                if (!ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0, 4).equals(listaFechas.get(listaFechas.size() - 1))) {
                    listaFechas.add(ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0, 4));
                }
            }
        }
        return listaFechas;
    }

    /**
      * Metodo usado para la creacion y modificacion
     * @param i parametro necesario para la ejecucion del metodo
     * @return IngresoGastoResponse
     */
    @Override
    public IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i) {
        return EntityToResponse(ingresoGastoRepository.save(DTOToEntity(i)));
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por el administrador y la entidad
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param clienteId parametro necesario para la ejecucion del metodo
     * @return Lista de IngresoGastoResponse
     */
    @Override
    public List<IngresoGastoResponse> avisosFacturasAdministradorId(int administradorId, int clienteId) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByAdministradorIdAndFechaPagoIsNullAndClienteId_IdCliente(administradorId, clienteId)) {
            ingresoGastoResponseList.add(EntityToResponse(i));
        }
        return ingresoGastoResponseList;
    }


}
