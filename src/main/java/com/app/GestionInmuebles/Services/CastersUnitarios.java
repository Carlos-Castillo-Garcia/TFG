package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;

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

    default InmueblesXClientesRespone bbddToResponseInmueblesXClientes(String bbdd){
        InmueblesXClientesRespone inmueblesXClientesRespone = new InmueblesXClientesRespone();
        String[] split = bbdd.split(",");
        inmueblesXClientesRespone.setApellidos(split[0]);
        inmueblesXClientesRespone.setNombre(split[1]);
        inmueblesXClientesRespone.setPorcentajePropiedad(Float.parseFloat(split[2]));

        return inmueblesXClientesRespone;
    }

    default InversionResponse bbddToResponseInversiones(String bbdd){
        InversionResponse inversionResponse = new InversionResponse(0,0,0);
        System.out.println(bbdd);
            String[] split = bbdd.split(",");
            if(!split[0].equals("null") && !split[1].equals("null")) {
                inversionResponse.setCompra(Float.parseFloat(split[0]));
                inversionResponse.setInversiones(Float.parseFloat(split[1]));
                inversionResponse.setTotal(Float.parseFloat(split[0]) + Float.parseFloat(split[1]));
                return inversionResponse;
            }else if(split[0].equals("null") && !split[1].equals("null")){
                inversionResponse.setCompra(0);
                inversionResponse.setInversiones(Float.parseFloat(split[1]));
                inversionResponse.setTotal(Float.parseFloat(split[0]) + Float.parseFloat(split[1]));
                return inversionResponse;
            }else if(!split[0].equals("null") && split[1].equals("null")){
                inversionResponse.setCompra(Float.parseFloat(split[0]));
                inversionResponse.setInversiones(0);
                inversionResponse.setTotal(Float.parseFloat(split[0]) + Float.parseFloat(split[1]));
                return inversionResponse;
            }
        return inversionResponse;
    }
}
