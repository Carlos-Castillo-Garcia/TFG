package com.app.GestionInmuebles.Services;


import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface PagosService {

    default PagosEntity DTOToEntity(PagosDTO inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        PagosEntity inmuebleEntity = modelMapper.map(inmueble, PagosEntity.class);
        return inmuebleEntity;
    }

    default PagosResponse EntityToResponse(PagosEntity inmueble) {
        ModelMapper modelMapper = new ModelMapper();
        PagosResponse inmuebleResponse = modelMapper.map(inmueble, PagosResponse.class);
        return inmuebleResponse;
    }

    List<PagosResponse> listarPagosIdAdministrador(int id);

    List<PagosResponse> listarPagosIdPagos(int id);

    PagosResponse createUpdatePagos(PagosDTO dto);

}
