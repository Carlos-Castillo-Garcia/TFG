package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosResponse;
import com.app.GestionInmuebles.Repository.Tipos.PeriodosRepository;
import com.app.GestionInmuebles.Services.Tipos.PeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("PeriodosServiceImpl")
public class PeriodosServiceImpl implements PeriodosService {

    //-------------------------------------------Variable Service de Periodos Repository----------------------------------------------
    @Autowired
    @Qualifier("PeriodosRepository")
    private PeriodosRepository tipoPeriodoRepository;

    //-------------------------------------------Metodos de la Clase Periodos Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de PeriodosResponse
     */
    @Override
    public List<PeriodosResponse> listarPeriodosadministradorId(int id) {
        List<PeriodosResponse> list = new ArrayList<>();
        for (PeriodosEntity i : tipoPeriodoRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }


    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de PeriodosResponse
     */
    @Override
    public List<PeriodosResponse> listarPeriodosidPeriodos(int id) {
        List<PeriodosResponse> list = new ArrayList<>();
        for (PeriodosEntity i : tipoPeriodoRepository.getByidTipoPeriodo(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    /**
     * Metodo para la usado creacion y modificacion
     * @param periodosDTO parametro necesario para la ejecucion del metodo
     * @return PeriodosResponse
     */
    @Override
    public PeriodosResponse createUpdatePeriodos(PeriodosDTO periodosDTO) {
        return EntityToResponse(tipoPeriodoRepository.save(DTOToEntity(periodosDTO)));
    }
}
