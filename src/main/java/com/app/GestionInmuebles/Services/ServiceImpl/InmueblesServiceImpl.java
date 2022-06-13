package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import com.app.GestionInmuebles.Repository.InmueblesRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*/**
  * @apiNote Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("InmueblesServiceImpl")
public class InmueblesServiceImpl implements InmuebleService, CastersUnitarios {

    //-------------------------------------------Variable Service de Inmueble Repository----------------------------------------------
    @Autowired
    @Qualifier("InmueblesRepository")
    private InmueblesRepository inmueblesRepository;

    //-------------------------------------------Metodos de la Clase Inmueble Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de
     */
    @Override
    public List<InmuebleResponse> listarInmueblesIdAdministrador(int id) {
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByadministradorId(id)) {
            if (!i.isBorrado()) {
                inmuebleResponseList.add(EntityToResponse(i));
            }
        }
        return inmuebleResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de InmuebleResponse
     */
    @Override
    public List<InmuebleResponse> listarInmueblesIdInmueble(int id) {
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByidInmueble(id)) {
                inmuebleResponseList.add(EntityToResponse(i));
        }
        return inmuebleResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por administrador y entidad
     * @param entidad parametro necesario para la ejecucion del metodo
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @return Lista de InmuebleResponse
     */
    @Override
    public List<InmuebleResponse> inmueblesByPorcentajeContratoAndEntidad(int idAdministrador, int entidad){
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByEntidadOrderByAlias(idAdministrador, entidad)) {
            inmuebleResponseList.add(EntityToResponse(i));
        }
        return inmuebleResponseList;
    }

    /**
      * Metodo usado para la creacion y modificacion
     * @param inmuebleDTO parametro necesario para la ejecucion del metodo
     * @return InmuebleResponse
     */
    @Override
    public InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO) {
        return EntityToResponse(inmueblesRepository.save(DTOToEntity(inmuebleDTO)));
    }

    /**
      * Metodo para la obtencion de un listado de registros de los inmuebles asociados a una entidad
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @return Lista de InmuebleResponse
     */
    @Override
    public List<InmueblesXClientesRespone> propiedad(int idCliente){
        List<InmueblesXClientesRespone> inmueblesXClientesRespones = new ArrayList<>();
        for (String i: inmueblesRepository.propiedad(idCliente, 1)) {
            inmueblesXClientesRespones.add(bbddToResponseInmueblesXClientes(i));
        }
        return inmueblesXClientesRespones;
    }

    /**
      * Metodo para la obtencion de un listado de registros de las inversiones sobre un inmueble
     * @param idInmueble parametro necesario para la ejecucion del metodo
     * @return Lista de InmuebleResponse
     */
    @Override
    public List<InversionResponse> inversion(int idInmueble){
        List<InversionResponse> inmueblesXClientesRespones = new ArrayList<>();
        for (String i: inmueblesRepository.inversiones(idInmueble)) {
            inmueblesXClientesRespones.add(bbddToResponseInversiones(i));
        }
        return inmueblesXClientesRespones;
    }
}
