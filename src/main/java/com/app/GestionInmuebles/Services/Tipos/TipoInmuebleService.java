package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Interfaz de Tipo de Inmueble
 * @author Carlos Castillo
 */
public interface TipoInmuebleService {
    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<TipoInmuebleEntity, TipoInmuebleResponse> ENTITYTORESPONSE = new PropertyMap<TipoInmuebleEntity, TipoInmuebleResponse>() {
        protected void configure() {
            map().setCategoriaId(source.getCategoriaId().getIdCategoria());
            map().setCategoria(source.getCategoriaId().getCategoria());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param tipoInmuebleDTO parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleEntity
     */
    default TipoInmuebleEntity DTOToEntity(TipoInmuebleDTO tipoInmuebleDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoInmuebleDTO, TipoInmuebleEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param tipoInmuebleEntity parametro necesario para la ejecucion del metodo
     * @return TipoInmuebleResponse
     */
    default TipoInmuebleResponse EntityToResponse(TipoInmuebleEntity tipoInmuebleEntity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(tipoInmuebleEntity, TipoInmuebleResponse.class);
    }

    List<TipoInmuebleResponse> listTipoInmuebleadministradorId(int id);

    List<TipoInmuebleResponse> listTipoInmuebleidInmuebles(int id);

    List<TipoInmuebleResponse> listTipoInmuebleidInmueblesByCategoria(int idCategoria, int idAdministrador);

    TipoInmuebleResponse createUpdateTipoInmueble(TipoInmuebleDTO tipoInmuebleDTO);
}
