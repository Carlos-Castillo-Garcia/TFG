package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import com.app.GestionInmuebles.Repository.ClientesRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */

@Service("ClienteServiceImpl")
public class ClienteServiceImpl implements ClienteService, CastersUnitarios {

    //-------------------------------------------Variable Service de Cliente Repository----------------------------------------------

    @Autowired
    @Qualifier(value = "ClientesRepository")
    private ClientesRepository clientesRepository;

    //-------------------------------------------Metodos de la Clase Cliente Service Impl-------------------------------------------------------

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de ClientesResponse
     */
    @Override
    public List<ClientesResponse> listarClientesadministradorId(int id) {
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i : clientesRepository.findByadministradorIdAndBorradoIsFalse(id)) {
            clientesResponseList.add(EntityToResponse(i));
        }
        return clientesResponseList;
    }

    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de ClientesResponse
     */
    @Override
    public List<ClientesResponse> listarClientesidCliente(int id) {
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i : clientesRepository.findByidClienteAndBorradoIsFalse(id)) {
            clientesResponseList.add(EntityToResponse(i));
        }
        return clientesResponseList;
    }

    /**
      * Metodo usado para la creacion y modificacion
     * @param i parametro necesario para la ejecucion del metodo
     * @return ClientesResponse
     */
    @Override
    public ClientesResponse createUpdateClientes(ClientesDTO i) {
        return EntityToResponse(clientesRepository.save(DTOToEntity(i)));
    }

    /**
      * Metodo para la obtencion de un listado de registros filtrados por el administrador
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @return Lista de ClientesResponse
     */
    @Override
    public List<ClientesResponse> clienteByInmueble(int idAdministrador){
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i : clientesRepository.clientesByInmuebles(idAdministrador)) {
            clientesResponseList.add(EntityToResponse(i));
        }
        return clientesResponseList;
    }

    /**
      * Metodo para la obtencion de un listado de registrosde las inversiones de un cliente
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @return Lista de ClientesResponse
     */
    @Override
    public List<InversionResponse> inversion(int idCliente){
        List<InversionResponse> clientesResponseList = new ArrayList<>();
        for (String i : clientesRepository.inversion(idCliente)) {
            clientesResponseList.add(bbddToResponseInversiones(i));
        }
        return clientesResponseList;
    }

}
