package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.ResponseUnitarios.InformesResponse;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.InformesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("InformesServiceImpl")
public class InformesServiceImpl implements InformesService, CastersUnitarios {

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
    public List<InformesResponse> informeXInmueble(int adminisitradorId, int idEntidad) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeXInmueble(idEntidad)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByInmuebleXAnio(int id, int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByInmuebleXAnios(id)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

    @Override
    public List<InformesResponse> informeByInmuebleAnioXMes(int id, int anio, int adminisitradorId) {
        List<InformesResponse> informesResponseList = new ArrayList<>();
        for (String i: ingresoGastoRepository.findInformeByInuebleAnioXMes(id, anio)) {
            informesResponseList.add(bbddToResponseInformes(i));
        }
        return informesResponseList;
    }

}
