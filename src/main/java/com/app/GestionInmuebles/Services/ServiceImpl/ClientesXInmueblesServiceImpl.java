package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.Repository.ClientesRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.ClientesXInmueblesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */

@Service("ClientesXInmueblesServiceImpl")
public class ClientesXInmueblesServiceImpl implements ClientesXInmueblesService, CastersUnitarios {

    //-------------------------------------------Variable Service de Clientes X Inmuebles Repository----------------------------------------------
    @Autowired
    @Qualifier("ClientesRepository")
    private ClientesRepository clientesRepository;

    //-------------------------------------------Metodos de la Clase Clientes X Inmuebles Service Impl-------------------------------------------------------

    /**
      * Metodo para la obtencion de un listado de registros filtrados por el cliente
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @return Lista de ClientesXInmueblesResponse
     */
    @Override
    public List<ClientesXInmueblesResponse> clientesXInmueblesList(int idCliente){
        List<ClientesXInmueblesResponse> clientesXInmueblesResponseList = new ArrayList<>();
        for (String i: clientesRepository.inmueblesXCliente(idCliente, 1)) {
            clientesXInmueblesResponseList.add(bbddToResponseClientesXInmuebles(i));
        }
        return clientesXInmueblesResponseList;
    }



}
