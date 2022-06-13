package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Tipo de Concepto
 * @author Carlos Castillo
 */
public interface TipoConceptoService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<TipoConceptoEntity, TipoConceptoResponse> ENTITYTORESPONSE = new PropertyMap<TipoConceptoEntity, TipoConceptoResponse>() {
        protected void configure() {
            map().setCategoriaId(source.getCategoriaId().getIdCategoria());
            map().setCategoria(source.getCategoriaId().getCategoria());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return TipoConceptoEntity
     */
    default TipoConceptoEntity DTOToEntity(TipoConceptoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoConceptoEntity.class);
    }

    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return  TipoConceptoResponse
     */
    default TipoConceptoResponse EntityToResponse(TipoConceptoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(i, TipoConceptoResponse.class);
    }

    List<TipoConceptoResponse> listarTiposConceptoAdministradorId(int id);

    List<TipoConceptoResponse> listarTiposConceptoAdministradorIdConceptoId(int idAdministrador, int idConcepto);

    List<TipoConceptoResponse> listarTiposConceptoId(int id);

    TipoConceptoResponse createUpdateTiposConcepto(TipoConceptoDTO tipoConceptoDTO);
}
