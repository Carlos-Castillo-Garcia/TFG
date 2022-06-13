package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.InformesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("InformesServiceImpl")
public class InformesServiceImpl implements InformesService, CastersUnitarios {

    //-------------------------------------------Variable Service de Repository----------------------------------------------
    @Autowired
    @Qualifier("IngresoGastoRepository")
    private IngresoGastoRepository ingresoGastoRepository;

    //-------------------------------------------Metodos de la Clase Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros filtrados por la entidad para lo
     * @param idEntidad parametro necesario para la ejecucion del metodo
     * @return Lista de InformesResponse
     */
    @Override
    public List<InformesResponse> informeXInmueble(int idEntidad) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i : ingresoGastoRepository.findInformeXInmueble(idEntidad)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por el Inmueble
     * @param inmuebleId parametro necesario para la ejecucion del metodo
     * @return Lista de  InformesResponse
     */
    @Override
    public List<InformesResponse> informeByInmuebleXAnio(int inmuebleId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i : ingresoGastoRepository.findInformeByInmuebleXAnios(inmuebleId)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por el Inmueble y el año
     * @param inmuebleId parametro necesario para la ejecucion del metodo
     * @param anio parametro necesario para la ejecucion del metodo
     * @return Lista de InformesResponse
     */
    @Override
    public List<InformesResponse> informeByInmuebleAnioXMes(int inmuebleId, int anio) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i : ingresoGastoRepository.findInformeByInuebleAnioXMes(inmuebleId, anio)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

}
