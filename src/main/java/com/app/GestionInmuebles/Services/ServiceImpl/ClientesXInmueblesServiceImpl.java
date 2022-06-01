package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;
import com.app.GestionInmuebles.Repository.ClientesRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.ClientesXInmueblesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ClientesXInmueblesServiceImpl")
public class ClientesXInmueblesServiceImpl implements ClientesXInmueblesService, CastersUnitarios {

    @Autowired
    @Qualifier("ClientesRepository")
    private ClientesRepository clientesRepository;

    @Override
    public List<ClientesXInmueblesResponse> temp(int idCliente){
        List<ClientesXInmueblesResponse> clientesXInmueblesResponseList = new ArrayList<>();
        for (String i: clientesRepository.inmueblesXCliente(idCliente)) {
            clientesXInmueblesResponseList.add(bbddToResponseClientesXInmuebles(i));
        }
        return clientesXInmueblesResponseList;
    }
}
