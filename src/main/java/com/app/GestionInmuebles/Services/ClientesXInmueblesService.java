package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.ClientesXInmueblesResponse;

import java.util.List;

/**
 * Interfaz de Clientes X Inmuebles
 * @author Carlos Castillo
 */
public interface ClientesXInmueblesService {

    List<ClientesXInmueblesResponse> clientesXInmueblesList(int idCliente);

}
