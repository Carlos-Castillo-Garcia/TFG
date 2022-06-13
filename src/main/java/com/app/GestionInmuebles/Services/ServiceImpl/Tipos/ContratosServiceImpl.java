package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import com.app.GestionInmuebles.Repository.Tipos.ContratosRepository;
import com.app.GestionInmuebles.Services.Tipos.ContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("ContratosServiceImpl")
public class ContratosServiceImpl implements ContratosService {

    //-------------------------------------------Variable Service de Contratos Repository----------------------------------------------

    @Autowired
    @Qualifier(value = "ContratosRepository")
    private ContratosRepository contratosRepository;

    //-------------------------------------------Metodos de la Clase Contratos Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de ContratosResponse
     */
    @Override
    public List<ContratosResponse> listarTiposContratoadministradorId(int id) {
        List<ContratosResponse> tipos_contratoResponses = new ArrayList<>();
        for (ContratosEntity i : contratosRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                tipos_contratoResponses.add(EntityToResponse(i));
            }
        }
        return tipos_contratoResponses;
    }

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de ContratosResponse
     */
    @Override
    public List<ContratosResponse> listarTiposContratoidContrato(int id) {
        List<ContratosResponse> tipos_contratoResponses = new ArrayList<>();
        for (ContratosEntity i : contratosRepository.getByidTipoContrato(id)) {
            tipos_contratoResponses.add(EntityToResponse(i));
        }
        return tipos_contratoResponses;
    }

    /**
     * Metodo para la usado creacion y modificacion
     * @param tiposContratoDTO parametro necesario para la ejecucion del metodo
     * @return ContratosResponse
     */
    @Override
    public ContratosResponse createUpdateTiposContrato(ContratosDTO tiposContratoDTO) {
        return EntityToResponse(contratosRepository.save(DTOToEntity(tiposContratoDTO)));
    }
}
