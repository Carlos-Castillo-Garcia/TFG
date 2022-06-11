package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;

import java.util.List;

public interface InformesService {

    InformesResponse informeGeneral(int id);

    List<InformesResponse> informeXInmueble(int adminisitradorId, int idEntidad);

    List<InformesResponse> informeByInmuebleXAnio(int id, int adminisitradorId);

    List<InformesResponse> informeByInmuebleAnioXMes(int id, int mes, int adminisitradorId);

}
