package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.InformesResponse;

import java.util.List;

public interface InformesService {

    default InformesResponse bbddToResponse (String bbdd){
        InformesResponse informesResponse = new InformesResponse();
        String[] split = bbdd.split(",");
        informesResponse.setTotalGastos(Float.parseFloat(split[0]));
        informesResponse.setTotalIngresos(Float.parseFloat(split[1]));
        informesResponse.setTotalBalance(Float.parseFloat(split[2]));
        informesResponse.setIdInmueble(Integer.parseInt(split[3]));
        informesResponse.setInmuebleAlias(split[4]);
        informesResponse.setAnio(split[5]);
        informesResponse.setNombreMes(split[6]);
        informesResponse.setNumeroMes(split[7]);

        return informesResponse;
    }

    InformesResponse informeGeneral(int id);
    List<InformesResponse> informeXInmueble(int adminisitradorId);

    List<InformesResponse> informeByInmuebleXAnio(int id, int adminisitradorId);

    List<InformesResponse> informeByInmuebleAnioXMes(int id, int mes, int adminisitradorId);

    List<InformesResponse> informeXAnio(int adminisitradorId);

    List<InformesResponse> informeByAnioXMeses(int adminisitradorId, int anio);

    List<InformesResponse> informeByAnioMesesXInmuebles(int adminisitradorId, int anio, int mes);
}
