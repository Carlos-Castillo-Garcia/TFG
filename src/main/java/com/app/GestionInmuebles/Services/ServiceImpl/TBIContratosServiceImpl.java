package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import com.app.GestionInmuebles.Repository.TBIContratosRepository;
import com.app.GestionInmuebles.Services.TBIContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */

@Service("TBIContratosServiceImpl")
public class TBIContratosServiceImpl implements TBIContratosService {

    //-------------------------------------------Variable Service de Contratos Repository----------------------------------------------
    @Autowired
    @Qualifier("TBIContratosRepository")
    private TBIContratosRepository tbiContratosRespository;

    //-------------------------------------------Metodos de la Clase Contratos Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TBIContratosResponse
     */
    @Override
    public List<TBIContratosResponse> listarContratosadministradorId(int id) {
        List<TBIContratosResponse> responses = new ArrayList<>();
        for (TBIContratosEntity i : tbiContratosRespository.getByadministradorIdOrderByInmuebleId_AliasDesc(id)) {
            if (!i.isBorrado()) {
                responses.add(EntityToResponse(i));
            }
        }
        return responses;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por el propietario del contrato
     * @param entidad parametro necesario para la ejecucion del metodo
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @return Lista de TBIContratosResponse
     */
    @Override
    public List<TBIContratosResponse> listarContratosPropietario(int idAdministrador, int entidad) {
        List<TBIContratosResponse> responses = new ArrayList<>();
        for (TBIContratosEntity i : tbiContratosRespository.getByEntidadOrderByInmuebleId_AliasAsc(idAdministrador, entidad)) {
            if (!i.isBorrado()) {
                responses.add(EntityToResponse(i));
            }
        }
        return responses;
    }

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TBIContratosResponse
     */
    @Override
    public List<TBIContratosResponse> listarContratosidContratos(int id) {
        List<TBIContratosResponse> responses = new ArrayList<>();
        for (TBIContratosEntity i : tbiContratosRespository.getByidContratos(id)) {
            responses.add(EntityToResponse(i));
        }
        return responses;
    }

    /**
     * Metodo usado para la creacion y modificacion
     * @param tbiContratosDTO parametro necesario para la ejecucion del metodo
     * @return TBIContratosResponse
     */
    @Override
    public TBIContratosResponse createUpdateContratos(TBIContratosDTO tbiContratosDTO) {
        return EntityToResponse(tbiContratosRespository.save(DTOToEntity(tbiContratosDTO)));
    }
}
