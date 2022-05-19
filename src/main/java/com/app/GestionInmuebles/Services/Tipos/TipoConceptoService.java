package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TipoConceptoService {
    default TipoConceptoEntity DTOToEntity(TipoConceptoDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoConceptoEntity.class);
    }

    default TipoConceptoResponse EntityToResponse(TipoConceptoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, TipoConceptoResponse.class);
    }

    List<TipoConceptoResponse> listarTiposConceptoAdministradorId(int id);

    List<TipoConceptoResponse> listarTiposConceptoId(int id);

    TipoConceptoResponse createUpdateTiposConcepto(TipoConceptoDTO tipoConceptoDTO);
}
