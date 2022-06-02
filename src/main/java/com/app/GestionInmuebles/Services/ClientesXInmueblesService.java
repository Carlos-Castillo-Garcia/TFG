package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;

import java.util.List;

public interface ClientesXInmueblesService {

    List<ClientesXInmueblesResponse> clientesXInmueblesList(int idCliente);

}
