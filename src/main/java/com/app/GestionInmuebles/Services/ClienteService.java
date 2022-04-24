package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface ClienteService {
    default ClientesEntity DTOToEntity(ClientesDTO i){
        ModelMapper modelMapper = new ModelMapper();
        ClientesEntity clientesEntity = modelMapper.map(i, ClientesEntity.class);
        return clientesEntity;
    }

    default ClientesResponse EntityToResponse(ClientesEntity i){
        ModelMapper modelMapper = new ModelMapper();
        ClientesResponse clientesResponse = modelMapper.map(i, ClientesResponse.class);
        return clientesResponse;
    }

    List<ClientesResponse> listar_Clientes();

    void CrearClientes(ClientesDTO i);
}
