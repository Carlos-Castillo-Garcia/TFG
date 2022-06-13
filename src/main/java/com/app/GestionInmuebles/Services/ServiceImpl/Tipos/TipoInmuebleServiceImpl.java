package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import com.app.GestionInmuebles.Repository.Tipos.TipoInmuebleRepository;
import com.app.GestionInmuebles.Services.Tipos.TipoInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */

@Service("TipoInmuebleServiceImpl")
public class TipoInmuebleServiceImpl implements TipoInmuebleService {

    //-------------------------------------------Variable Service de Tipo Inmueble Repository----------------------------------------------
    @Autowired
    @Qualifier("TipoInmuebleRepository")
    private TipoInmuebleRepository tipoInmuebleRepository;

    //-------------------------------------------Metodos de la Clase Tipo Inmueble Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoInmuebleResponse
     */
    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleadministradorId(int id) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    /**
      * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoInmuebleResponse
     */
    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleidInmuebles(int id) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.getByidTipoInmueble(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por la categoria
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @param idCategoria parametro necesario para la ejecucion del metodo
     * @return Lista de TipoInmuebleResponse
     */
    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleidInmueblesByCategoria(int idCategoria, int idAdministrador) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(0, idCategoria, idAdministrador)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    /**
      * Metodo usado para la creacion y modificacion
     * @param tipoInmuebleDTO parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleResponse
     */
    @Override
    public TipoInmuebleResponse createUpdateTipoInmueble(TipoInmuebleDTO tipoInmuebleDTO) {
        return EntityToResponse(tipoInmuebleRepository.save(DTOToEntity(tipoInmuebleDTO)));
    }
}
