package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.Repository.ClientesRepository;
import com.app.GestionInmuebles.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ClienteServiceImpl")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    @Qualifier(value = "ClientesRepository")
    private ClientesRepository clientesRepository;

    @Override
    public List<ClientesResponse> listarClientesadministradorId(int id) {
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i : clientesRepository.findByadministradorId(id)) {
            if (!i.isBorrado()) {
                clientesResponseList.add(EntityToResponse(i));
            }
        }
        return clientesResponseList;
    }

    @Override
    public List<ClientesResponse> listarClientesidCliente(int id) {
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i : clientesRepository.findByidCliente(id)) {
            clientesResponseList.add(EntityToResponse(i));
        }
        return clientesResponseList;
    }

    @Override
    public ClientesResponse createUpdateClientes(ClientesDTO i) {
        return EntityToResponse(clientesRepository.save(DTOToEntity(i)));
    }
}
