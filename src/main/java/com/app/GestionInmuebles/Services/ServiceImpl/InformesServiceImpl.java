package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.InformesResponse;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.InformesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("InformesServiceImpl")
public class InformesServiceImpl implements InformesService {

    @Autowired
    @Qualifier("IngresoGastoRepository")
    private IngresoGastoRepository ingresoGastoRepository;

    @Override
    public InformesResponse informeGeneral(int id) {
        InformesResponse informesResponse = new InformesResponse();
        float ingresos = 0;
        float gastos = 0;
        for (IngresoGastoEntity i : ingresoGastoRepository.findByAdministradorId(id)) {
            ingresos = ingresos + i.getTotalIngreso();
            gastos = gastos + i.getTotalGasto();
        }
        informesResponse.setTotalIngresos(ingresos);
        informesResponse.setTotalGastos(gastos);
        informesResponse.setTotalBalance(informesResponse.getTotalIngresos() - informesResponse.getTotalGastos());
        return informesResponse;
    }

    @Override
    public List<InformesResponse> informeXInmueble(int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeXInmueble(adminisitradorId)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByInmuebleXAnio(int id, int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByInmuebleXAnios(id, adminisitradorId)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByInmuebleAnioXMes(int id, int anio, int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByInuebleAnioXMes(id, anio, adminisitradorId)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeXAnio(int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeXAnios(adminisitradorId)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByAnioXMeses(int adminisitradorId, int anio) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByAniosXMeses(adminisitradorId, anio)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByAnioMesesXInmuebles(int adminisitradorId, int anio, int mes) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByAniosMesesXInmuebles(adminisitradorId, anio, mes)) {
            informesResponseList.add(bbddToResponse(i));
        }
        return informesResponseList;
    }

}
