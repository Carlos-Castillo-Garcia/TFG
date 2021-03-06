package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;

import java.text.DateFormatSymbols;

/**
 * Interfaz de Casters Unitarios
 * Interfaz para Mapeos de querys especificas
 * @author Carlos Castillo
 */
public interface CastersUnitarios {

    /**
     * Mapper de String a Response
     * Mapea el string devuelto por la query a Informes Response
     * @param bbdd parametro necesario para la ejecucion del metodo
     * @return InformesResponse
     */
    default InformesResponse bbddToResponseInformes(String bbdd){
        InformesResponse informesResponse = new InformesResponse();
        String[] split = bbdd.split(",");
        informesResponse.setTotalGastos(Float.parseFloat(split[0]));
        informesResponse.setTotalIngresos(Float.parseFloat(split[1]));
        informesResponse.setTotalBalance(Float.parseFloat(split[2]));
        informesResponse.setIdInmueble(Integer.parseInt(split[3]));
        informesResponse.setInmuebleAlias(split[4]);
        if (split.length == 6){
            informesResponse.setAnio(split[5]);
        }else{
            informesResponse.setAnio("0");
        }
        if (split.length == 7){
            informesResponse.setNombreMes(new DateFormatSymbols().getMonths()[ Integer.parseInt(split[6]) -1]);
            informesResponse.setNumeroMes(split[6]);
        }else{
            informesResponse.setNombreMes("");
            informesResponse.setNumeroMes("0");
        }
        return informesResponse;
    }

    /**
     * Mapper de String a Response
     * Mapea el string devuelto por la query a ClientesXInmuebles Response
     * @param bbdd parametro necesario para la ejecucion del metodo
     * @return ClientesXInmueblesResponse
     */
    default ClientesXInmueblesResponse bbddToResponseClientesXInmuebles(String bbdd){
        ClientesXInmueblesResponse clientesXInmueblesResponse = new ClientesXInmueblesResponse();
        String[] split = bbdd.split(",");
        clientesXInmueblesResponse.setAlias(split[0]);
        clientesXInmueblesResponse.setPorcentajePropiedad(Float.parseFloat(split[1]));

        return clientesXInmueblesResponse;
    }

    /**
     * Mapper de String a Response
     * Mapea el string devuelto por la query a InmueblesXClientes Response
     * @param bbdd parametro necesario para la ejecucion del metodo
     * @return InmueblesXClientesRespone
     */
    default InmueblesXClientesRespone bbddToResponseInmueblesXClientes(String bbdd){
        InmueblesXClientesRespone inmueblesXClientesRespone = new InmueblesXClientesRespone();
        System.out.println(bbdd);
        String[] split = bbdd.split(",");
        inmueblesXClientesRespone.setApellidos(split[0]);
        inmueblesXClientesRespone.setNombre(split[1]);
        inmueblesXClientesRespone.setPorcentajePropiedad(Float.parseFloat(split[2]));

        return inmueblesXClientesRespone;
    }

    /**
     * Mapper de String a Response
     * Mapea el string devuelto por la query a Inversion Response
     * @param bbdd parametro necesario para la ejecucion del metodo
     * @return InversionResponse
     */
    default InversionResponse bbddToResponseInversiones(String bbdd){
        InversionResponse inversionResponse = new InversionResponse(0,0,0);
        if(!bbdd.equals("null,null")){
            String[] split = bbdd.split(",");
            if(!split[0].equals("null") && split[1].equals("null")) {
                inversionResponse.setCompra(Float.parseFloat(split[0]));
                inversionResponse.setInversiones(0);
                inversionResponse.setTotal(Float.parseFloat(split[0]) + 0);
                return inversionResponse;
            }else if(split[0].equals("null") && !split[1].equals("null")){
                inversionResponse.setCompra(0);
                inversionResponse.setInversiones(Float.parseFloat(split[1]));
                inversionResponse.setTotal(0 + Float.parseFloat(split[1]));
                return inversionResponse;
            }else{
                inversionResponse.setCompra(Float.parseFloat(split[0]));
                inversionResponse.setInversiones(Float.parseFloat(split[1]));
                inversionResponse.setTotal(Float.parseFloat(split[0]) + Float.parseFloat(split[1]));
                return inversionResponse;
            }
        }
        return inversionResponse;
    }
}
