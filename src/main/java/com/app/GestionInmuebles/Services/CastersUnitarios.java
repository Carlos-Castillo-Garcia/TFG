package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;

public interface CastersUnitarios {
    default InformesResponse bbddToResponseInformes(String bbdd){
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

    default ClientesXInmueblesResponse bbddToResponseClientesXInmuebles(String bbdd){
        ClientesXInmueblesResponse clientesXInmueblesResponse = new ClientesXInmueblesResponse();
        String[] split = bbdd.split(",");
        clientesXInmueblesResponse.setAlias(split[0]);
        clientesXInmueblesResponse.setPorcentajePropiedad(Float.parseFloat(split[1]));

        return clientesXInmueblesResponse;
    }
}
