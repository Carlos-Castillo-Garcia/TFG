package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface ClienteService {
    default ClientesEntity DTOToEntity(ClientesDTO i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ClientesEntity.class);
    }

    default ClientesResponse EntityToResponse(ClientesEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, ClientesResponse.class);
    }

    List<ClientesResponse> listarClientes();

    ClientesResponse crearClientes(ClientesDTO i);
}
