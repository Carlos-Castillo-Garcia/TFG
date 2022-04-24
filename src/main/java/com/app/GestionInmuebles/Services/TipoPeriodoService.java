package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosDTO;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosEntity;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface TipoPeriodoService {
    default TipoPeriodosEntity DTOToEntity(TipoPeriodosDTO tipoPeriodosDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoPeriodosDTO, TipoPeriodosEntity.class);
    }

    default TipoPeriodosResponse EntityToResponse(TipoPeriodosEntity tipoPeriodosEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoPeriodosEntity, TipoPeriodosResponse.class);
    }

    List<TipoPeriodosResponse> listarTiposPeriodos();
    TipoPeriodosResponse crearTipoPeriodo(TipoPeriodosDTO tipoPeriodosDTO);
}
