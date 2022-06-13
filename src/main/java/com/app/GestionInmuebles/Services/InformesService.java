package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;

import java.util.List;

/**
 * Interfaz de Informes
 * @author Carlos Castillo
 */
public interface InformesService {

    List<InformesResponse> informeXInmueble(int idEntidad);

    List<InformesResponse> informeByInmuebleXAnio(int id);

    List<InformesResponse> informeByInmuebleAnioXMes(int id, int mes);

}
