package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

public interface TipoInmuebleService {

    PropertyMap<TipoInmuebleEntity, TipoInmuebleResponse> ENTITYTORESPONSE = new PropertyMap<TipoInmuebleEntity, TipoInmuebleResponse>() {
        protected void configure() {
            map().setCategoriaId(source.getCategoriaId().getIdCategoria());
            map().setCategoria(source.getCategoriaId().getCategoria());
        }
    };

    default TipoInmuebleEntity DTOToEntity(TipoInmuebleDTO tipoInmuebleDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoInmuebleDTO, TipoInmuebleEntity.class);
    }

    default TipoInmuebleResponse EntityToResponse(TipoInmuebleEntity tipoInmuebleEntity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        return modelMapper.map(tipoInmuebleEntity, TipoInmuebleResponse.class);
    }

    List<TipoInmuebleResponse> listTipoInmuebleadministradorId(int id);

    List<TipoInmuebleResponse> listTipoInmuebleidInmuebles(int id);

    TipoInmuebleResponse createUpdateTipoInmueble(TipoInmuebleDTO tipoInmuebleDTO);
}
