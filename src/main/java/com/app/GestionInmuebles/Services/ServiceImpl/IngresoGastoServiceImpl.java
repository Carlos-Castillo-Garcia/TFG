package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.IngresoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("IngresoGastoServiceImpl")
public class IngresoGastoServiceImpl implements IngresoGastoService {

    @Autowired
    @Qualifier("IngresoGastoRepository")
    private IngresoGastoRepository ingresoGastoRepository;

    @Override
    public List<IngresoGastoResponse> listarIngresoGastoInmuebleId(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByInmuebleId_IdInmueble(id)) {
            if (!i.isBorrado()) {
                ingresoGastoResponseList.add(EntityToResponse(i));
            }
        }
        return ingresoGastoResponseList;
    }

    @Override
    public List<IngresoGastoResponse> listarIngresoGastoId(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByIdInGa(id)) {
            ingresoGastoResponseList.add(EntityToResponse(i));
        }
        return ingresoGastoResponseList;
    }

    @Override
    public IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i) {
        return EntityToResponse(ingresoGastoRepository.save(DTOToEntity(i)));
    }
}
