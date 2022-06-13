package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import org.modelmapper.ModelMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Interfaz de Clientes
 * @author Carlos Castillo
 */
public interface ClienteService {
    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return ClientesEntity
     */
    default ClientesEntity DTOToEntity(ClientesDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ClientesEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param i parametro necesario para la ejecucion del metodo
     * @return ClientesResponse
     */
    default ClientesResponse EntityToResponse(ClientesEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ClientesResponse.class);
    }

    List<ClientesResponse> listarClientesadministradorId(int id);

    List<ClientesResponse> listarClientesidCliente(int id);

    ClientesResponse createUpdateClientes(ClientesDTO i);

    List<ClientesResponse> clienteByInmueble(int idAdministrador);

    List<InversionResponse> inversion(int idCliente);
}
