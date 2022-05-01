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
    @Qualifier("ClientesRepository")
    private ClientesRepository clientesRepository;

    @Override
    public List<ClientesResponse> listarClientes() {
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (ClientesEntity i:clientesRepository.findAll()) {
            if (i.getBorrado() == 0) {
                clientesResponseList.add(EntityToResponse(i));
            }
        }
        return clientesResponseList;
    }

    @Override
    public ClientesResponse createUpdateClientes(ClientesDTO i) {
        return EntityToResponse(clientesRepository.save(DTOToEntity(i)));
    }
}
