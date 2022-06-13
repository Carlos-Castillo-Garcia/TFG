package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import com.app.GestionInmuebles.Repository.Tipos.TipoConceptoRepository;
import com.app.GestionInmuebles.Services.Tipos.TipoConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("TipoConceptoServiceImpl")
public class TipoConceptoServiceImpl implements TipoConceptoService {

    //-------------------------------------------Variable Service de Tipo Concepto Repository----------------------------------------------
    @Autowired
    @Qualifier("TipoConceptoRepository")
    private TipoConceptoRepository tipoConceptoRepository;

    //-------------------------------------------Metodos de la Clase Tipo Concepto Service Impl-------------------------------------------------------

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoConceptoResponse
      * Metodo para la obtencion de un listado de registros
     */
    @Override
    public List<TipoConceptoResponse> listarTiposConceptoAdministradorId(int id) {
        List<TipoConceptoResponse> tipoConceptoResponseList = new ArrayList<>();
        for (TipoConceptoEntity i : tipoConceptoRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                tipoConceptoResponseList.add(EntityToResponse(i));
            }
        }
        return tipoConceptoResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrado por la categoria
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @param idConcepto parametro necesario para la ejecucion del metodo
     * @return Lista de TipoConceptoResponse
     */
    @Override
    public List<TipoConceptoResponse> listarTiposConceptoAdministradorIdConceptoId(int idAdministrador, int idConcepto) {
        List<TipoConceptoResponse> tipoConceptoResponseList = new ArrayList<>();
        for (TipoConceptoEntity i : tipoConceptoRepository.findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(0, idConcepto, idAdministrador)) {
            if (!i.isBorrado()) {
                tipoConceptoResponseList.add(EntityToResponse(i));
            }
        }
        return tipoConceptoResponseList;
    }

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoConceptoResponse
     */
    @Override
    public List<TipoConceptoResponse> listarTiposConceptoId(int id) {
        List<TipoConceptoResponse> tipoConceptoResponseList = new ArrayList<>();
        for (TipoConceptoEntity i : tipoConceptoRepository.getByidTipoConcepto(id)) {
            tipoConceptoResponseList.add(EntityToResponse(i));
        }
        return tipoConceptoResponseList;
    }

    /**
     * Metodo usado para la creacion y modificacion
     * @param tipoConceptoDTO parametro necesario para la ejecucion del metodo
     * @return TipoConceptoResponse
     */
    @Override
    public TipoConceptoResponse createUpdateTiposConcepto(TipoConceptoDTO tipoConceptoDTO) {
        return EntityToResponse(tipoConceptoRepository.save(DTOToEntity(tipoConceptoDTO)));
    }
}
