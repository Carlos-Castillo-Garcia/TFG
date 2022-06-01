package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;

import java.util.List;

public interface InformesService {

    InformesResponse informeGeneral(int id);
    List<InformesResponse> informeXInmueble(int adminisitradorId);

    List<InformesResponse> informeByInmuebleXAnio(int id, int adminisitradorId);

    List<InformesResponse> informeByInmuebleAnioXMes(int id, int mes, int adminisitradorId);

    List<InformesResponse> informeXAnio(int adminisitradorId);

    List<InformesResponse> informeByAnioXMeses(int adminisitradorId, int anio);

    List<InformesResponse> informeByAnioMesesXInmuebles(int adminisitradorId, int anio, int mes);
}
