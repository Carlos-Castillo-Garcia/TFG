package com.app.GestionInmuebles.Services.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Interfaz de Tipos de Periodo
 * @author Carlos Castillo
 */
public interface PeriodosService {
    /**
     * Mapper de DTO a Entity
     * @param PeriodosDTO parametro necesario para la ejecucion del metodo
     * @return PeriodosEntity
     */
    default PeriodosEntity DTOToEntity(PeriodosDTO PeriodosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(PeriodosDTO, PeriodosEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param PeriodosEntity parametro necesario para la ejecucion del metodo
     * @return PeriodosEntity
     */
    default PeriodosResponse EntityToResponse(PeriodosEntity PeriodosEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(PeriodosEntity, PeriodosResponse.class);
    }

    List<PeriodosResponse> listarPeriodosadministradorId(int id);

    List<PeriodosResponse> listarPeriodosidPeriodos(int id);

    PeriodosResponse createUpdatePeriodos(PeriodosDTO PeriodosDTO);
}
