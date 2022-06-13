package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosResponse;
import com.app.GestionInmuebles.Repository.Tipos.PagosRepository;
import com.app.GestionInmuebles.Services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("PagosServiceImpl")
public class PagosServiceImpl implements PagosService {

    //-------------------------------------------Variable Service de Tipo Pagos Repository----------------------------------------------
    @Autowired
    private PagosRepository pagosRepository;

    //-------------------------------------------Metodos de la Clase Tipo Pagos Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de PagosResponse
     */
    @Override
    public List<PagosResponse> listarPagosIdAdministrador(int id) {
        List<PagosResponse> pagosResponseList = new ArrayList<>();
        for (PagosEntity i : pagosRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                pagosResponseList.add(EntityToResponse(i));
            }
        }
        return pagosResponseList;
    }

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de PagosResponse
     */
    @Override
    public List<PagosResponse> listarPagosIdPagos(int id) {
        List<PagosResponse> pagosResponseList = new ArrayList<>();
        for (PagosEntity i : pagosRepository.findByIdTipoPago(id)) {
            pagosResponseList.add(EntityToResponse(i));
        }
        return pagosResponseList;
    }

    /**
     * Metodo para la usado creacion y modificacion
     * @param dto parametro necesario para la ejecucion del metodo
     * @return PagosResponse
     */
    @Override
    public PagosResponse createUpdatePagos(PagosDTO dto) {
        return EntityToResponse(pagosRepository.save(DTOToEntity(dto)));
    }
}
